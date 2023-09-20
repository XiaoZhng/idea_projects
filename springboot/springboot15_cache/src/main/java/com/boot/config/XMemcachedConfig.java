package com.boot.config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author Alonso
 */
@Configuration
public class XMemcachedConfig {

    @Autowired
    private XMemcachedProperties xMemcachedProperties;

    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {
        XMemcachedClientBuilder xMemcachedClientBuilder = new XMemcachedClientBuilder(xMemcachedProperties.getServers());
        xMemcachedClientBuilder.setConnectionPoolSize(xMemcachedProperties.getPoolSize());
        xMemcachedClientBuilder.setConnectTimeout(xMemcachedProperties.getOpTimeout());
        MemcachedClient memcachedClient = xMemcachedClientBuilder.build();
        return memcachedClient;
    }
}
