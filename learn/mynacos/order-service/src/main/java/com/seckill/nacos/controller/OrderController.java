package com.seckill.nacos.controller;

import com.seckill.nacos.entity.Order;
import com.seckill.nacos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

  @Autowired
  OrderService orderService;

  @Autowired
  RestTemplate restTemplate;

  @GetMapping("/createOrder")
  public void createOrder(@RequestParam("userName") String userName,
      @RequestParam("productId") Long productId, @RequestParam("orderCount") Integer orderCount,
      @RequestParam("point") Long point) {
    Order order = new Order();
    order.setProductId(productId);
    order.setUsername(userName);
    orderService.createOrder(order, productId, orderCount, point);
  }

  @GetMapping("/deductStock")
  public String deductStock(@RequestParam("orderCount") Integer orderCount,
      @RequestParam("productId") Long productId) {
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(
        "http://stock-service/deductStock?productId=" + productId + "&stockCount=" + orderCount,
        String.class);

    return responseEntity.getBody();
  }
}

