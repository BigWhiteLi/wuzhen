package com.example.demo929.configuration;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class JedisConfig {
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        // SpringBoot自动帮我们在容器中生成了一个RedisTemplate和一个StringRedisTemplate。
        // 但是，这个RedisTemplate的泛型是<Object,Object>，写代码不方便，需要写好多类型转换的代码；
        // 我们需要一个泛型为<String,Object>形式的RedisTemplate。
        // 并且，这个RedisTemplate没有设置数据存在Redis时，key及value的序列化方式。

        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);

        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        //jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
//        redisTemplate.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        // key采用String的序列化方式
        redisTemplate.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        // hash的value序列化方式采用jackson
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);

//        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }
}
