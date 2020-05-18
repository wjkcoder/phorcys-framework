package cn.phorcys.framework.redis.config;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/11 12:54 下午
 */
public interface RedisClient<V> {
    V get(String key);

    void set(String key,V value);

    void set(String key, V value, long timeToLive, TimeUnit timeUnit);

    boolean delete(String key);

    boolean trySet(String key, V value, long timeToLive, TimeUnit timeUnit);

    boolean compareAndSet(String key, V expect, V update, long timeToLive, TimeUnit timeUnit);
}
