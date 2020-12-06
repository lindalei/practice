package com.seckill.nacos.service;

import com.seckill.nacos.entity.Order;
import com.seckill.nacos.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

  @Autowired
  OrderRepository orderRepository;

  @Autowired
  StockService stockService;

  @Autowired
  CreditService creditService;

  @Transactional
  public void createOrder(Order order, Long productId, Integer stockCount, Long point) {
    orderRepository.save(order);
    System.out.println("创建订单成功");
    stockService.deductStock(productId, stockCount);
    creditService.updateCredit(order.getUsername(),point);
  }
}
