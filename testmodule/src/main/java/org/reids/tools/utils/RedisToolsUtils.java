package org.reids.tools.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 * @author jeckbin
 * @date 2019-09-18
 */

@Component
public final class RedisToolsUtils {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    //============common method============

    /**
     * 制定缓存失效时间
     * @param key redis的key
     * @param time 失效时间（秒）
     * @return
     */
    public boolean expire(String key,long time){
        try {
            if (time > 0)
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key获取其过期时间
     * @param key 键 不能为null
     * @return 时间（秒） 返回0代表永久有效
     */
    public long getExpireByKey(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 是否存在key
     * @param key
     * @return 存在true,不存在false
     */
    public boolean isExistKey(String key){
        try{
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     * @param key  可以传一个值或多个
     */
    public void delete(String... key){
        if(key != null && key.length > 0){
            if(key.length == 1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }


    //==============数据类型String================

    /**
     * 普通缓存获取
     * @param key
     * @return
     */
    public Object get(String key){
        return key == null?null:redisTemplate.opsForValue().get(key);
    }


    /**
     * 普通缓存放入
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,Object value){
        try{
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存放入并设置时间
     * @param key
     * @param value
     * @param time 时间（秒） 如果时间小于0，则设置无限期
     * @return
     */
    public boolean set(String key,Object value,long time){
        try{
            if(time > 0){
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            }else{
                set(key,value);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 递增
     * @param key
     * @param delta 要增加几，递增因子（大于0）
     * @return
     */
    public long incr(String key,long delta){
        if(delta < 0){
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key,delta);
    }

    /**
     * 递减
     * @param key
     * @param delta 要减少几，递减因子（大于0）
     * @return
     */
    public long decr(String key,long delta){
        if(delta < 0){
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key,-delta);
    }

    //=================数据结构Map==============

    /**
     * 获取mapx项
     * @param key 缓存键
     * @param item map键
     * @return
     */
    public Object hget(String key,String item){
        return redisTemplate.opsForHash().get(key,item);
    }

    /**
     * 根据key获取Map集合数据
     * @param key
     * @return
     */
    public Map<Object,Object> hmget(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    

}
