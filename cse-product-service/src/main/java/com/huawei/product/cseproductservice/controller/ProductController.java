package com.huawei.product.cseproductservice.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huawei.product.cseproductservice.entity.TProduct;
import com.huawei.product.cseproductservice.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
@EnableCircuitBreaker
@RequestMapping(value = "/product")
public class ProductController {
  private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

  @Autowired
  private ProductService productService;

  @HystrixCommand
  @PostMapping(value = "/createProduct")
  public ResponseEntity<String> createProduct(@RequestBody TProduct product) {
    if (product == null) {
      logger.error("when register product, product can not be null");
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(productService.insertProduct(product));
  }

  @HystrixCommand
  @DeleteMapping(value = "/removeProduct")
  public ResponseEntity<String> removeProduct(@RequestParam("id") String id) {
    if (StringUtils.isBlank(id)) {
      return ResponseEntity.badRequest().body("id can not be empty");
    }
    productService.deleteProductById(id);
    return ResponseEntity.ok(String.format("删除 %s成功!", id));
  }

  @HystrixCommand
  @GetMapping(value = "/getProductInfoById")
  public ResponseEntity<TProduct> getProductInfoById(@RequestParam("id") String id) {
    if (StringUtils.isBlank(id)) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(productService.findProductById(id));
  }

  @HystrixCommand
  @GetMapping(value = "/buy/{userId}")
  public ResponseEntity<String> buy(@RequestParam("id") String productId, @PathVariable("userId") String userId) {
    if (StringUtils.isBlank(productId) || StringUtils.isBlank(userId)) {
      return ResponseEntity.badRequest().body("id can not be empty");
    }
    boolean result = productService.buyProduct(userId, productId);
    if (result) {
      return ResponseEntity.ok(String.format(" user %s 购买 product %s 成功!", userId, productId));
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(String.format("product id %s 不存在,或者改物品已经被购买", productId));
    }
  }

  @HystrixCommand
  @GetMapping(value = "/cancelBuy/{userId}")
  public ResponseEntity<String> cancelBuy(@RequestParam("id") String productId, @PathVariable("userId") String userId) {
    if (StringUtils.isBlank(productId) || StringUtils.isBlank(userId)) {
      return ResponseEntity.badRequest().body("id can not be empty");
    }
    boolean result = productService.cancelProduct(userId, productId);
    if (result) {
      return ResponseEntity.ok(String.format(" user %s 取消购买 product %s 成功!", userId, productId));
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(String.format("product id %s 不存在,或者该物品没有被你购买", productId));
    }
  }

  @HystrixCommand
  @GetMapping(value = "/getAllProduct")
  public ResponseEntity<List<TProduct>> getAllProduct() {
    List<TProduct> product = productService.getAllProducts();
    if (product.size() == 0) {
      logger.warn(" product list is empty");
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    return ResponseEntity.ok(product);
  }
}
