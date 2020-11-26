package com.mymq.mymq;

import org.springframework.scheduling.config.ScheduledTask;

import java.util.Timer;
import java.util.TimerTask;

public class Schedule {
  public static void main(String[] args) {
    Timer timer= new Timer();
    timer.schedule(new TimerTask(){
      @Override
      public void run() {
        System.out.println("repeat");
      }
    },0,1000);

  }
}
