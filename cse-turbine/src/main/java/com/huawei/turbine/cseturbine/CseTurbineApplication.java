package com.huawei.turbine.cseturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
public class CseTurbineApplication {

  public static void main(String[] args) {
    SpringApplication.run(CseTurbineApplication.class, args);
  }
}

