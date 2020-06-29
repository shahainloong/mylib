package com.ac.mylib.util;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.ehcache.event.EventType;
import org.ehcache.impl.events.CacheEventAdapter;

/**
 * @author C5294803
 */
public class MyEhcacheListener extends CacheEventAdapter {
    @Override
    protected void onExpiry(Object key, Object expiredValue) {
        System.out.println("hello onExpiry and " + key + "," + expiredValue);
    }

    @Override
    protected void onCreation(Object key, Object newValue) {
        System.out.println("hello onCreation and " + key + "," + newValue);
    }
}
