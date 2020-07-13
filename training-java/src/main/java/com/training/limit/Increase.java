package com.training.limit;

import redis.clients.jedis.Jedis;

public class Increase {


    public static void main(String[] args) throws InterruptedException {
        String key = "apiName";
        int limitCount = 1000;
        int expire = 60;

        Jedis jedis = new Jedis("127.0.0.1", 6379);
        for (int i = 0; i < 10000; i++) {
            // 判断值是否超过限定值
            if (!checkKey(jedis, key, limitCount)) {
                System.out.println("超过限流阈值");
                return;
            }
            //
            incrKey(jedis, key, expire);
        }
    }


    /**
     * 对对应的值进行递增
     *
     * @param jedis
     * @param expire
     */
    private static void incrKey(Jedis jedis, String key, int expire) {
        if (jedis.ttl(key) < 0) {
            jedis.incr(key);
            jedis.expire(key, expire);
        } else {
            jedis.incr(key);
        }
    }


    /**
     * 判断值是否超过限定值
     *
     * @param jedis
     * @return
     */
    private static boolean checkKey(Jedis jedis, String key, int limitCount) {
        if (null != jedis.get(key)) {
            if (Integer.parseInt(jedis.get(key)) >= limitCount) {
                return false;
            }
        }
        return true;
    }
}