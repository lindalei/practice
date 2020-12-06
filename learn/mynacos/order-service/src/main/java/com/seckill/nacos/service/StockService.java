package com.seckill.nacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "stock-service",fallback = StockServiceFallback.class)
public interface StockService {

  @GetMapping("deductStock?productId={productId}&stockCount={stockCount}")
  String deductStock(@RequestParam("productId") Long productId,
      @RequestParam("stockCount") Integer stockCount);
}
