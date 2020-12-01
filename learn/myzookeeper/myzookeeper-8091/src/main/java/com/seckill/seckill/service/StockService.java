package com.seckill.seckill.service;

import com.seckill.seckill.entity.Stock;
import com.seckill.seckill.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

  @Autowired
  StockRepository stockRepository;

  public Stock getStockByName(String name) {
    Stock stock =
        stockRepository.findByName(name).orElseThrow(() -> new RuntimeException("name not found"));
    return stock;
  }

  @Transactional
  public int reduceStock(Stock stock) {
    stock.setStock(stock.getStock() - 1);
    stockRepository.save(stock);
    return 1;
  }
}
