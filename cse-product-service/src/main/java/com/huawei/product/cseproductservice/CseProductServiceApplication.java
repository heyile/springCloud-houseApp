package com.huawei.product.cseproductservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.huawei.product.cseproductservice.mapper")
@EnableEurekaClient
@SpringBootApplication
public class CseProductServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CseProductServiceApplication.class, args);
  }
}

