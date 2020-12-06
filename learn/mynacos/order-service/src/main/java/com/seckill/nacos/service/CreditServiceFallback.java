package com.seckill.nacos.service;

public class CreditServiceFallback implements CreditService {
  @Override
  public String updateCredit(String userName, Long point) {
    System.out.println("credit service fallback");
    return "credit fallback success";
  }
}
