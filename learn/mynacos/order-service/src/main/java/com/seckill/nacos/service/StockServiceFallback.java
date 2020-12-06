package com.seckill.nacos.service;

public class StockServiceFallback implements StockService {
  @Override
  public String deductStock(Long productId, Integer stockCount) {
    System.out.println("stock service fallback");
    return "fallback success";
  }
}
