package com.example.boot3.redis.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

/**
 * @author by KingOfTetris
 * @date 2023/6/6
 */
@Configuration
public class AppRedisConfiguration {


    //允许Object类型的k-v 都可以被转化为json格式存储到redis中
    //自定义一个RedisTemplate不用SpringBoot自动配置的
    //实现自定义序列化标准
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        //这个东西GenericJackson2JsonRedisSerializer
        //是导入Jackson包以后才有的。
        //把对象转化为json格式的序列化器
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}
