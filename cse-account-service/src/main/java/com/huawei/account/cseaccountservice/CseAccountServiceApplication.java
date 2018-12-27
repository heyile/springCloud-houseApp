package com.huawei.account.cseaccountservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.huawei.account.cseaccountservice.mapper")
@SpringBootApplication
public class CseAccountServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CseAccountServiceApplication.class, args);
  }
}

