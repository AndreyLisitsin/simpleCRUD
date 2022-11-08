package com.lisitsin.configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Context {

    private ObjectFactory factory;
    private Map<Class, Object> cache = new ConcurrentHashMap<>();

    private Config config;

    public Context(Config config) {
        this.config = config;
    }

    public <T> T getObject(Class<T> type){
        return null;
    }
}
