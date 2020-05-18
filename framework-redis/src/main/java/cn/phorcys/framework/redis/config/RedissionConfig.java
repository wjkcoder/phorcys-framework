package cn.phorcys.framework.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/11 12:59 上午
 */
@Configuration
public class RedissionConfig {
    @Autowired
    private PhorcysRedisProperties redisProperties;

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        String redisUrl = String.format("redis://%s:%s",redisProperties.getHost()+"",redisProperties.getPort()+"");
        config.useSingleServer().setAddress(redisUrl).setPassword(redisProperties.getPassword());
        config.useSingleServer().setDatabase(redisProperties.getDatabase());
        return Redisson.create(config);
    }
}
