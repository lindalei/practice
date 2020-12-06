package com.seckill.nacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "credit-service",fallback = CreditServiceFallback.class)
public interface CreditService {

  @GetMapping("updateCredit")
  String updateCredit(@RequestParam("userName") String userName,
      @RequestParam("point") Long point);
}
