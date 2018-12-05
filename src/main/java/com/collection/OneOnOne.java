package com.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by XD.Wang on 2017/3/21.
 * 一对一双向映射，K类型不能等于V
 *
 * @author XD.Wang
 */
public class OneOnOne<K, V> {

    private AtomicInteger index = new AtomicInteger(0);

    private ConcurrentHashMap<Integer, K> m1;

    private ConcurrentHashMap<Integer, V> m2;

    public OneOnOne() {
        m1 = new ConcurrentHashMap<>();
        m2 = new ConcurrentHashMap<>();
    }

}
