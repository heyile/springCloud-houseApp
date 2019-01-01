package com.huawei.zuul.csezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class CseZuulApplication {

  public static void main(String[] args) {
    SpringApplication.run(CseZuulApplication.class, args);
  }
}

