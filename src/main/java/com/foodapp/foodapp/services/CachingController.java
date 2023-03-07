package com.foodapp.foodapp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CachingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CachingController.class);

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/clear-cache")
    public void clearAllCaches() {
        LOGGER.debug("Clear all cache");
        cacheManager.getCacheNames()
                .forEach(cacheName -> Objects.requireNonNull(cacheManager.getCache(cacheName)).clear());
    }
}