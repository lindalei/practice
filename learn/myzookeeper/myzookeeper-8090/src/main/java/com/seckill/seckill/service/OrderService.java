package com.seckill.seckill.service;

import com.seckill.seckill.entity.Order;
import com.seckill.seckill.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  OrderRepository orderRepository;

  public void saveOrder(Order order) {
    orderRepository.save(order);
  }
}
