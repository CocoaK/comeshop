package com.eshop.serviceapp.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
//    @Value("${spring.redis.password}")
//    private String password;
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//    @Value("${spring.redis.database}")
//    private int database;
    @Value("${spring.redis.maxIdle}")
    private int maxIdle;
//    @Value("${spring.redis.maxTotal}")
//    private int maxTotal;
//    @Value("${spring.redis.maxWaitMillis}")
//    private int maxWaitMillis;
    @Value("${spring.redis.minIdle}")
    private int minIdle;

    @Bean
    public JedisPoolConfig getRedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
//        config.setMaxTotal(maxTotal);
//        config.setMaxWaitMillis(maxWaitMillis);
        config.setMinIdle(minIdle);
        return config;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setDatabase(0);
//        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
//        jedisClientConfiguration.connectTimeout(Duration.ofSeconds(timeout));// 60s connection timeout
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory(redisStandaloneConfiguration,
                jedisClientConfiguration.build());
        return jedisConFactory;
    }
}