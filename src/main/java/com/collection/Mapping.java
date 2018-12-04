package com.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Mapping<K, V> {

    private AtomicInteger index = new AtomicInteger(0);

    private ConcurrentHashMap<Integer, K> m1;

    private ConcurrentHashMap<Integer, V> m2;

    public Mapping() {
        m1 = new ConcurrentHashMap<>();
        m2 = new ConcurrentHashMap<>();
    }

}
