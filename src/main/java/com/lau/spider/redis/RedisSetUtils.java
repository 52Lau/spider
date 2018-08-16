package com.lau.spider.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author SteveLau
 * @date 2018/8/1
 * <p>
 * 人生可否变作漫长浪漫程序！
 * @description
 */
public class RedisSetUtils {

    public static Long sadd(String key,String value){
        Jedis jedis;
        jedis = new Jedis("127.0.0.1", 6379);
        //权限认证
        jedis.auth("123456");
        //添加
        return jedis.sadd(key,value);
    }

    public static Set<String> smembers(String key) {
        Jedis jedis;
        jedis = new Jedis("127.0.0.1", 6379);
        //权限认证
        jedis.auth("123456");
        //添加
        return jedis.smembers(key);
    }

}
