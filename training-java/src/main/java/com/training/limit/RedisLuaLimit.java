package com.training.limit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import java.util.Collections;

/**
 *
 */
public class RedisLuaLimit {

    /**
     * lua脚本
     * local key_local = redis.call('setnx',KEYS[1],0)
     *
     * if tonumber(key_local) == 0 then
     *     if tonumber(redis.call('get',KEYS[1]))>=tonumber(ARGV[2]) then
     *         return false
     *     else
     *         redis.call('incr',KEYS[1])
     *         return true
     *     end
     * else
     *     redis.call('incr',KEYS[1])
     *     redis.call('pexpire',KEYS[1],ARGV[1])
     *     return true
     * end
     * @param args
     */
    public static void main(String[] args) {

    }

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 针对某个key使用lua脚本进行限流
     * 使用lua优点，可以保证多个命令是一次行传输到Redis服务器并且是串行执行的，保证串行执行的命令中不行插入其他命令，防止并发问题
     * 步骤：
     * 1、判断key是否存在，如果不存在，保存该key，设置值为1，设置多少毫秒（n）最多进行几次（m)
     * 2、如果值存在，先判断key是否超时了，如果超时则删除，并重新执行步骤1，如果key未超时，则判断是否超过n毫秒最多m次的限制
     *
     * @param key
     */
    public Boolean getGlobalLimitByLua(String key, int mlitimes, int maxCount) {
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("/limit.lua")));
        redisScript.setResultType(Boolean.class);

        return redisTemplate.execute(redisScript, Collections.singletonList(key), String.valueOf(mlitimes), String.valueOf(maxCount));
    }
}
