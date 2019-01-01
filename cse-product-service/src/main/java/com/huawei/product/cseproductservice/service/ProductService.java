package com.huawei.product.cseproductservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huawei.product.cseproductservice.entity.TProduct;
import com.huawei.product.cseproductservice.mapper.TProductMapper;

@Service
public class ProductService {
  private final static Logger logger = LoggerFactory.getLogger(ProductService.class);

  @Autowired
  private TProductMapper tProductMapper;

  public String insertProduct(TProduct tProduct) {
    int insert = tProductMapper.insert(tProduct);
    logger.info("result : " + insert);
    logger.info("id : " + tProduct.getId());
    return tProduct.getId();
  }

  public List<TProduct> getAllProducts() {
    List<TProduct> tProducts = tProductMapper.selectAll();
    if (tProducts != null && tProducts.size() != 0) {
      return tProducts;
    }
    logger.warn("No Product in the list");
    return new ArrayList<>();
  }

  public TProduct findProductById(String id) {
    TProduct tProduct = tProductMapper.selectByPrimaryKey(id);
    if (tProduct != null) {
      return tProduct;
    }
    logger.warn("the Product {} is not exist ", id);
    return null;
  }

  public void deleteProductById(String id) {
    tProductMapper.deleteByPrimaryKey(id);
  }

  public boolean buyProduct(String userId, String productId) {
    TProduct tProduct = tProductMapper.selectByPrimaryKey(productId);
    if (tProduct != null) {
      if (tProduct.getReserved()) {
        logger.warn("productId {} is reserved ", productId);
        return false;
      }
      tProduct.setReserved(true);
      tProduct.setBuyerUserId(userId);
      int i = tProductMapper.updateByPrimaryKey(tProduct);
      logger.info(" update product affect {} record", i);
      return i == 1;
    }
    return false;
  }

  public boolean cancelProduct(String userId, String productId) {
    TProduct tProduct = tProductMapper.selectByPrimaryKey(productId);
    if (tProduct != null) {
      if (userId.equals(tProduct.getBuyerUserId())) {
        tProduct.setReserved(false);
        tProduct.setBuyerUserId(null);
        int i = tProductMapper.updateByPrimaryKey(tProduct);
        logger.info(" update product affect {} record", i);
        return i == 1;
      }
    }
    return false;
  }
}
