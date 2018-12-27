package com.huawei.user.cseuserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.huawei.user.cseuserservice.mapper")
@SpringBootApplication
public class CseUserServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CseUserServiceApplication.class, args);
  }
}

