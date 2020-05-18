package cn.phorcys.framework.redis.config;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/11 1:02 下午
 */
@Component
public class PhorcysRedissionClient<V> implements RedisClient<V> {
    private RedissonClient redissonClient;

    @Autowired
    public PhorcysRedissionClient(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }


    @Override
    public V get(String key) {
        RBucket<V> bucket = redissonClient.getBucket(key);
        return bucket.get();
    }

    @Override
    public void set(String key, V value) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.set(value);
    }

    @Override
    public void set(String key, V value, long timeToLive, TimeUnit timeUnit) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.set(value,timeToLive,timeUnit);
    }

    @Override
    public boolean delete(String key) {
        return redissonClient.getBucket(key).delete();
    }

    @Override
    public boolean trySet(String key, V value, long timeToLive, TimeUnit timeUnit) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        return bucket.trySet(value,timeToLive,timeUnit);

    }

    @Override
    public boolean compareAndSet(String key, V expect, V update, long timeToLive, TimeUnit timeUnit) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        return bucket.compareAndSet(expect,update);
    }
}
