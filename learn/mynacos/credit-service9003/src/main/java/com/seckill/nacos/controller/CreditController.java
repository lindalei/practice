package com.seckill.nacos.controller;

import com.seckill.nacos.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditController {

  @Autowired
  CreditService creditService;

  @GetMapping("/updateCredit")
  public String updateCredit(@RequestParam("userName") String userName,
      @RequestParam("point") Long point) {
    creditService.updateCredit(userName, point);
    return "update credit successfully";
  }
}
