package com.qa.config;

import java.util.HashMap;

public enum TestContext {
    CONTEXT;

    ThreadLocal<HashMap<String,Object>> testContext = ThreadLocal.withInitial(() -> new HashMap<>());

    public <T> T testSet(String key, T Object){
        testContext.get().put("Key",Object);
        return Object;
    }

    public <T> T testGet(String key){
        return (T)testContext.get().get(key);
    }
}
