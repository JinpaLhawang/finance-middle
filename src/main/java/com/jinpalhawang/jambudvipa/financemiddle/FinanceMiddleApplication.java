package com.jinpalhawang.jambudvipa.financemiddle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FinanceMiddleApplication {

  public static void main(String[] args) {
    SpringApplication.run(FinanceMiddleApplication.class, args);
  }

}
