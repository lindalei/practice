package com.mymq.mymq.service;

import com.mymq.mymq.entity.Message;
import com.mymq.mymq.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class ScheduleMQService {
  @Autowired
  MessageMapper messageMapper;

  public void schedule(String userId) {

    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        List<Message> messages = messageMapper.queryMessage(userId);
        for (Message message: messages){
          System.out.println(message.getMessageId());
        }
      }
    }, 0, 2000);
  }
}
