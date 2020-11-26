package com.cloudExample1.cloudExample1.myspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClient1000 {
  public static void main(String[] args) {
    SpringApplication.run(EurekaClient1000.class, args);
  }
}
