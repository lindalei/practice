package com.seckill.seckill.controller;

import com.seckill.seckill.entity.Stock;
import com.seckill.seckill.service.StockService;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecKillController {

  @Autowired
  StockService stockService;

  @Autowired
  CuratorFramework curatorFramework;


  @GetMapping("/kill")
  public void secKill(@RequestParam(value = "stockName") String stockName) throws Exception {
    InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework, "/product-apple");

    try {
      interProcessMutex.acquire();
      Stock stock = stockService.getStockByName("apple");
      if (stock.getStock() <= 0) {
        throw new RuntimeException("overloaded");
      }
      int i = stockService.reduceStock(stock);
      if (i == 1) {
        System.out.println("successfully reduce stock");
      } else {
        throw new RuntimeException("reduce stock fail");
      }
    } catch (Exception e) {
      throw new RuntimeException("reduce stock failed");
    } finally {
      interProcessMutex.release();
    }
  }

  @GetMapping("/hello")
  public String hello() {
    return "success";
  }
}
