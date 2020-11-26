package com.mymq.mymq.web;

import com.mymq.mymq.entity.Account;
import com.mymq.mymq.service.ScheduleMQService;
import com.mymq.mymq.service.TransferMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MQSendController {
  @Autowired
  TransferMoneyService service;

  @Autowired
  ScheduleMQService scheduleMQService;

  @RequestMapping("/queryAccount")
  public String queryAccount(@RequestParam("userId") String userId){
    Account account = service.queryAccount(userId).get(0);
    System.out.println(account.getAmount());
    System.out.println(account.getUpdate_time());

    return "ok";
  }

  @RequestMapping("/transferAmount")
  public String transferAmout(@RequestParam("userId") String userId,
      @RequestParam("amount") int amount) {
    try {
      service.updateAccount(userId, amount);
      return "success";
    } catch (Exception e) {
      return "error";
    }
  }

  @RequestMapping("/queryMessage")
  public String queryUnconfirmedMessage(@RequestParam("userId") String userId) {
    try {
      scheduleMQService.schedule(userId);
      return "success";
    } catch (Exception e) {
      return "error";
    }
  }
}
