package org.techsys.test.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
@Slf4j
public class JedisUtils {

    @Autowired
    private JedisPool jedisPool;

    private Jedis getJedis(){
        return jedisPool.getResource();
    }

    /**
     * 设值
     */
    public String ser(String key,String value){
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.set(key, value);
        }catch (Exception e){
           return  null;
        }
    }

}
