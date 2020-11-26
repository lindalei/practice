package com.myredisson.myredisson.web;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedissonController {
  @Autowired
  Redisson redisson;

  @Autowired
  StringRedisTemplate stringRedisTemplate;

  @RequestMapping("/reduce_product")
  public void reduce() {
    String lockKey = "lockKey";
    RLock lock = redisson.getLock(lockKey);
    try {
      lock.lock();
      int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
      if (stock > 0) {
        int newStock = stock - 1;
        stringRedisTemplate.opsForValue().set("stock", newStock + "");
      } else {
        System.out.println("减库存失败");
      }
    } finally {
      lock.unlock();
    }
  }
}
