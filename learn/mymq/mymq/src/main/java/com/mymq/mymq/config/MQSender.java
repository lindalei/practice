package com.mymq.mymq.config;

import com.alibaba.fastjson.JSONObject;
import com.mymq.mymq.entity.Message;
import org.springframework.amqp.core.AmqpTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQSender {
  @Autowired
  AmqpTemplate amqpTemplate;

  public void send(String exchange, String routingKey, Message message) {
    String sendMessage= JSONObject.toJSONString(message);
    amqpTemplate.convertAndSend(exchange,routingKey,sendMessage);
  }
}
