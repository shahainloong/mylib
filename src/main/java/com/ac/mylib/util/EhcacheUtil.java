package com.ac.mylib.util;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.*;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.event.EventType;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.impl.config.event.DefaultCacheEventListenerConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: EhcacheConfig
 * Description: Ehcache配置
 * Author: johnnybro@qq.com
 * Date: 2018/05/18 14:30:36
 */
@Configuration
@EnableCaching
public class EhcacheUtil {
    private static CacheManager cacheManager;

    /**
     * 初始化Ehcache缓存对象
     */
    public EhcacheUtil() {
        CacheEventListenerConfigurationBuilder cacheEventListenerConfiguration = CacheEventListenerConfigurationBuilder.newEventListenerConfiguration(new MyEhcacheListener(), EventType.CREATED).unordered().asynchronous();
        System.out.println("[Ehcache配置初始化<开始>]");

        // 配置默认缓存属性
        CacheConfiguration<String, String> cacheConfiguration = CacheConfigurationBuilder.newCacheConfigurationBuilder(
                // 缓存数据K和V的数值类型
                // 在ehcache3.3中必须指定缓存键值类型,如果使用中类型与配置的不同,会报类转换异常
                String.class, String.class,
                ResourcePoolsBuilder
                        .newResourcePoolsBuilder()
                        //设置缓存堆容纳元素个数(JVM内存空间)超出个数后会存到offheap中
                        .heap(1000L, EntryUnit.ENTRIES)
                        //设置堆外储存大小(内存存储) 超出offheap的大小会淘汰规则被淘汰
                        .offheap(100L, MemoryUnit.MB)
                        // 配置磁盘持久化储存(硬盘存储)用来持久化到磁盘,这里设置为false不启用
                        .disk(500L, MemoryUnit.MB, false)
        ).withExpiry(Expirations.timeToLiveExpiration(
                //设置缓存过期时间
                Duration.of(3L, TimeUnit.SECONDS))
        ).withExpiry(Expirations.timeToIdleExpiration(
                //设置被访问后过期时间(同时设置和TTL和TTI之后会被覆盖,这里TTI生效,之前版本xml配置后是两个配置了都会生效)
                Duration.of(60L, TimeUnit.SECONDS))
                // 缓存淘汰策略 默认策略是LRU（最近最少使用）。你可以设置为FIFO（先进先出）或是LFU（较少使用）。
                // 这块还没看
        /*.withEvictionAdvisor(
                new OddKeysEvictionAdvisor<Long, String>())*/
        ).add(cacheEventListenerConfiguration).build();
        // CacheManager管理缓存
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                // 硬盘持久化地址
                .with(CacheManagerBuilder.persistence("D:/ehcacheData"))
                // 设置一个默认缓存配置
                .withCache("defaultCache", cacheConfiguration)
                //创建之后立即初始化
                .build(true);

        System.out.println("[Ehcache配置初始化<完成>]");
    }

    public static void main(String[] args) {
        CacheEventListenerConfigurationBuilder cacheEventListenerConfiguration = CacheEventListenerConfigurationBuilder
                .newEventListenerConfiguration(new MyEhcacheListener(), EventType.CREATED, EventType.UPDATED)
                .unordered().asynchronous();
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                                ResourcePoolsBuilder.heap(100))
                                .build())
                .build(true);

        Cache<Long, String> preConfigured
                = cacheManager.getCache("preConfigured", Long.class, String.class);

        Cache<Long, String> myCache = cacheManager.createCache("myCache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                        ResourcePoolsBuilder.heap(100)).add(cacheEventListenerConfiguration).build());

        myCache.put(1L, "da one!");
        preConfigured.put(1L, "do one!");

        String value = myCache.get(1L);
        System.out.println(preConfigured.get(1L));

        cacheManager.close();
    }

}

