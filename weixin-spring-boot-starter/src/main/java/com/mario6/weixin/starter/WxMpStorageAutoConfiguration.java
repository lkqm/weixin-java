package com.mario6.weixin.starter;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInRedisConfigStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 微信公众号存储策略自动配置
 */
@Configuration
public class WxMpStorageAutoConfiguration {

    @Autowired
    private WxMpProperties wxMpProperties;

    @Autowired(required = false)
    private JedisPool jedisPool;

    @Bean
    @ConditionalOnMissingBean(WxMpConfigStorage.class)
    public WxMpConfigStorage wxMpInMemoryConfigStorage() {
        WxMpProperties.Storage storage = wxMpProperties.getStorage();
        WxMpProperties.StorageType type = storage.getType();

        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        if (type == WxMpProperties.StorageType.redis) {
            config = getRedisConfigStorage();
        }

        setWxMpInfo(config);
        return config;
    }

    private void setWxMpInfo(WxMpInMemoryConfigStorage config) {
        WxMpProperties.App app = wxMpProperties.getApp();
        config.setAppId(app.getAppId());
        config.setSecret(app.getSecret());
        config.setToken(app.getToken());
        config.setAesKey(app.getAesKey());
    }

    private WxMpInRedisConfigStorage getRedisConfigStorage() {
        JedisPool poolToUse = jedisPool;
        if (poolToUse == null) {
            poolToUse = getJedisPool();
        }
        WxMpInRedisConfigStorage config = new WxMpInRedisConfigStorage(poolToUse);
        setWxMpInfo(config);
        return config;
    }

    private JedisPool getJedisPool() {
        WxMpProperties.Storage storage = wxMpProperties.getStorage();
        RedisProperties redis = storage.getRedis();

        JedisPoolConfig config = new JedisPoolConfig();
        if (redis.getMaxActive() != null) {
            config.setMaxTotal(redis.getMaxActive());
        }
        if (redis.getMaxIdle() != null) {
            config.setMaxIdle(redis.getMaxIdle());
        }
        if (redis.getMaxWaitMillis() != null) {
            config.setMaxWaitMillis(redis.getMaxWaitMillis());
        }
        if (redis.getMinIdle() != null) {
            config.setMinIdle(redis.getMinIdle());
        }
        config.setTestOnBorrow(true);
        config.setTestWhileIdle(true);

        JedisPool pool = new JedisPool(config, redis.getHost(), redis.getPort(),
                redis.getTimeout(), redis.getPassword(), redis.getDatabase());
        return pool;
    }
}
