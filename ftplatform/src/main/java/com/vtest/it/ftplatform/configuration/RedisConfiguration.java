package com.vtest.it.ftplatform.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
public class RedisConfiguration {
    @Bean("redisCacheManager")
    @Primary
    public RedisCacheManager redisCacheManager(JedisConnectionFactory connectionFactory) {
        Set<String> cacheNames = new HashSet<>();
        cacheNames.add("ftCache");
        Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig().disableCachingNullValues();
        configurationMap.put("ftCache", configuration.entryTtl(Duration.ofDays(3)).serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer())));
        return RedisCacheManager.builder(connectionFactory).initialCacheNames(cacheNames).withInitialCacheConfigurations(configurationMap).build();
    }
}
