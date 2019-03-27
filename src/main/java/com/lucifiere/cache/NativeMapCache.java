package com.lucifiere.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 基于Guava的LRU本地缓存
 * 实现了Spring Cache，可以直接配置使用
 *
 * @author XD.Wang
 * @date 2018/11/02.
 */
public class NativeMapCache implements Cache {

    private static final Logger LOGGER = LoggerFactory.getLogger(NativeMapCache.class);

    private static final Object NULL_HOLDER = new NullHolder();

    private static final int DEFAULT_CONCURRENT_LEVEL = 10;

    /**
     * 是否允许空值
     */
    private boolean allowNullValues = true;

    /**
     * Cache的名称
     */
    String name = "";

    /**
     * Cache初始容量
     */
    int initCapacity = 100;

    /**
     * Cache最大容量
     */
    long maxCapacity = 1000;

    /**
     * 本地cache的超时时间,默认不超时
     */
    private long localCacheExpireMs = 0;

    /**
     * Cache库
     */
    private Map<Object, Object> store;

    public boolean isAllowNullValues() {
        return allowNullValues;
    }

    public void setAllowNullValues(boolean allowNullValues) {
        this.allowNullValues = allowNullValues;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInitCapacity() {
        return initCapacity;
    }

    public void setInitCapacity(int initCapacity) {
        this.initCapacity = initCapacity;
    }

    public long getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(long maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public long getLocalCacheExpireMs() {
        return localCacheExpireMs;
    }

    public void setLocalCacheExpireMs(long localCacheExpireMs) {
        this.localCacheExpireMs = localCacheExpireMs;
    }

    public Map<Object, Object> getStore() {
        return store;
    }

    public void setStore(Map<Object, Object> store) {
        this.store = store;
    }

    /**
     * 初始化
     * 缓存基础：Guava
     */
    public void init() {
        Preconditions.checkArgument(initCapacity <= 0, "initCapacity must be greater than 0");
        Preconditions.checkArgument(maxCapacity <= 0, "maxCapacity must be greater than 0");
        Preconditions.checkArgument(StringUtils.isBlank(name), "name can't be null");
        CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder()
                .initialCapacity(initCapacity)
                .maximumSize(maxCapacity)
                .concurrencyLevel(DEFAULT_CONCURRENT_LEVEL);
        if (localCacheExpireMs > 0) {
            builder.expireAfterWrite(localCacheExpireMs, TimeUnit.MILLISECONDS);
        }
        this.store = builder.build().asMap();
    }

    @Override
    public Object getNativeCache() {
        return this.store;
    }

    @Override
    public ValueWrapper get(Object key) {
        Object value = this.store.get(key);
        return (value != null ? new SimpleValueWrapper(Objects.requireNonNull(fromStoreValue(value))) : null);
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        throw new UnsupportedOperationException("get(Object key, Class<T> type) isn't supported");
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        throw new UnsupportedOperationException("get(Object key, Callable<T> valueLoader) isn't supported");
    }

    @Override
    public void put(Object key, Object value) {
        Object v = toStoreValue(value);
        this.store.put(key, v);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        throw new UnsupportedOperationException("putIfAbsent(Object key, Object value) isn't supported");
    }

    @Override
    public void evict(Object key) {
        throw new UnsupportedOperationException("evict(Object key) isn't supported");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("clear() isn't supported");
    }

    /**
     * 把从store得到的值转换为用户的值
     *
     * @param storeValue 原始结果
     * @return 结果
     */
    private Object fromStoreValue(Object storeValue) {
        if (this.allowNullValues && storeValue.equals(NULL_HOLDER)) {
            return null;
        }
        return storeValue;
    }

    /**
     * 放入到store中的值
     *
     * @param userValue 待存储的值
     * @return 值
     */
    private Object toStoreValue(Object userValue) {
        if (this.allowNullValues && userValue == null) {
            return NULL_HOLDER;
        }
        return userValue;
    }

    /**
     * 空占位符
     * for. 防止缓存穿透
     */
    private static class NullHolder implements Serializable {
        @Override
        public boolean equals(Object obj) {
            return (obj != null && obj instanceof NullHolder);
        }
    }

}
