package com.seckill.nacos.service;

import com.seckill.nacos.repo.StockRepository;
import com.seckill.nacos.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StockService {

  @Autowired
  StockRepository stockRepository;

  @Transactional
  public void deductStock(Integer stockCount, Long productId) {
    Optional<Stock> stock = stockRepository.findByProductId(productId);
    if (!stock.isPresent()) {
      throw new RuntimeException("product not exist");
    }
    stockRepository.deductStock(stockCount, productId);
  }
}
