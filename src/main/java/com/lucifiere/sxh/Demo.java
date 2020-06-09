package com.lucifiere.sxh;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.SetUtils;

import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author created by XD.Wang
 * Date 2020/6/9.
 */
public class Demo {

    public static <K, V> boolean isMapSame(Map<K, V> m1, Map<K, V> m2, BiFunction<V, V, Boolean> comparator) {
        if (MapUtils.isEmpty(m1) && MapUtils.isEmpty(m2)) {
            return true;
        }
        if (MapUtils.isEmpty(m1) || MapUtils.isEmpty(m2)) {
            return false;
        }
        if (m1.size() != m2.size()) {
            return false;
        }
        if (!SetUtils.isEqualSet(m1.keySet(), m2.keySet())) {
            return false;
        }
        for (K key : m1.keySet()) {
            V v1 = m1.get(key);
            V v2 = m2.get(key);
            boolean isEqual = comparator.apply(v1, v2);
            if (!isEqual) {
                return false;
            }
        }
        return true;
    }

}
