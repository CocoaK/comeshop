package com.eshop.serviceapp.redis;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.nio.charset.Charset;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MybatisRedisCache implements Cache {

    private static JedisConnectionFactory jedisConnectionFactory;
    private final static Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);

    private final String id;

    private static final  String MAPPER_CACHE_KEY = "MAPPER:";

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public MybatisRedisCache(final String id) {
        logger.info("---------------------MybatisRedisCache---------------------");
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    /**
     * 按照一定规则标识key
     */
    private String getKey(Object key) {
        StringBuilder accum = new StringBuilder();
        accum.append(MAPPER_CACHE_KEY);
        accum.append(this.id).append(":");
        accum.append(DigestUtils.md5Hex(String.valueOf(key)));
        return accum.toString();
    }

    /**
     * redis key规则前缀
     */
    private String getKeys() {
        return MAPPER_CACHE_KEY + this.id + ":*";
    }

    @Override
    public String getId() {
        logger.info("---------------------getId---------------------");
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        logger.info("---------------------putObject-key---------------------");
        RedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            byte[] k = getKey(key).getBytes(Charset.forName("utf-8"));
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            connection.set(k, serializer.serialize(value));
        } catch (JedisConnectionException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public Object getObject(Object key) {
        logger.info("---------------------getObject---------------------");
        Object result = null;
        RedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            result = serializer.deserialize(connection.get(getKey(key).getBytes(Charset.forName("utf-8"))));
        } catch (JedisConnectionException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    @Override
    public Object removeObject(Object key) {
        logger.info("---------------------removeObject---------------------");
        RedisConnection connection = null;
        Object result = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            result = connection.expire(getKey(key).getBytes(Charset.forName("utf-8")), 0);
        } catch (JedisConnectionException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    @Override
    public void clear() {
        RedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            Set<byte[]> keys = connection.keys(getKeys().getBytes(Charset.forName("utf-8")));
            logger.info("------发生CUD操作，清空对应Mapper缓存----->"+keys.size());
            for (byte[] key : keys) {
                connection.del(key);
            }
//            connection.flushDb();
//            connection.flushAll();
        } catch (JedisConnectionException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    @Override
    public int getSize() {
        logger.info("---------------------getSize---------------------");
        int result = 0;
        RedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            result = Integer.valueOf(connection.dbSize().toString());
        } catch (JedisConnectionException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        MybatisRedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }
}


