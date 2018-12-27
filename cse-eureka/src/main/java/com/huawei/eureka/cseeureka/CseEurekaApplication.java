package com.huawei.eureka.cseeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CseEurekaApplication {

  public static void main(String[] args) {
    SpringApplication.run(CseEurekaApplication.class, args);
  }
}

