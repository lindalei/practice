//package com.nacos.nacos.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class OrderService {
//
//  @Autowired
//  OrderRepository orderRepository;
//
//  @Autowired
//  StockService stockService;
//
//  @Transactional
//  public void createOrder(Order order, Long productId, Integer stockCount) {
//    orderRepository.save(order);
//    System.out.println("创建订单成功");
//    stockService.deductStock(productId, stockCount);
//  }
//}
