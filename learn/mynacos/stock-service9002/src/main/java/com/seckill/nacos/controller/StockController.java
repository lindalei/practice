package com.seckill.nacos.controller;

import com.seckill.nacos.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

  @Autowired
  StockService stockService;

  @GetMapping("/deductStock")
  public String deductStock(@RequestParam("productId") Long productId,
      @RequestParam("stockCount") Integer stockCount) {
    stockService.deductStock(stockCount, productId);
    return "reduce stock successfully";
  }
}
