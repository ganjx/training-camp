package com.training.redis;

import redis.clients.jedis.Jedis;

import java.util.concurrent.*;

public class RedisMain {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        String host = "116.62.205.109";
        int port = 6379;


        Jedis jedis = new Jedis(host, port);
        String key = "test";

        int count = 1000000;
        for (int i = 0; i < count; i++) {
            jedis.set(key + "i", key + "i");
        }
        //
        System.out.println("耗时:" + (System.currentTimeMillis() - start));
        jedis.close();
    }
}
