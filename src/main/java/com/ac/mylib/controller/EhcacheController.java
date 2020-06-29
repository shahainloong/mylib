package com.ac.mylib.controller;

import com.ac.mylib.util.MyEhcacheListener;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheEventListenerConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.event.EventType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ehcache")
public class EhcacheController {
    public String read() {
        CacheEventListenerConfigurationBuilder cacheEventListenerConfiguration = CacheEventListenerConfigurationBuilder
                .newEventListenerConfiguration(new MyEhcacheListener(), EventType.CREATED, EventType.UPDATED)
                .unordered().asynchronous();

        final CacheManager manager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("foo",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, String.class, ResourcePoolsBuilder.heap(10))
                                .add(cacheEventListenerConfiguration)
                ).build(true);

        final Cache<String, String> cache = manager.getCache("foo", String.class, String.class);
        cache.put("Hello", "World");
        cache.put("Hello", "Everyone");
        cache.remove("Hello");
        return cache.toString();
    }
}
