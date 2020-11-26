package com.myredisson.myredisson;

import redis.clients.jedis.Jedis;

import java.util.List;

public class BlockRedis {
  private static boolean stop = false;

  public static void main(String[] args) {
    Jedis jedis = new Jedis("127.0.0.1");
    while (!stop) {
      List<String> bkey = jedis.blpop(5, "bkey");
      //      if (bkey != null && !bkey.isEmpty()) {
      //        System.out.println("get key successfully");
      //        stop = true;
      //      } else {
      //        System.out.println("no key ready");
      //      }

      String result = jedis.brpoplpush("bkey", "bkey_back", 5);
      if (result != null) {
        System.out.println("get key successfully " + result);
        if (true) {
          throw new RuntimeException();
        }
        jedis.lrem("bkey_back", -1, result);
        //stop = true;
      } else {
        System.out.println("no key ready");
      }
    }
  }
}
