package com.collection;

/**
 * 不可变的一对一双向映射，K类型不能等于V
 *
 * @author XD.Wang
 * @date 2017/3/21.
 */
public class Mapping<K, V> {
//
//    private final HashMap<Integer, K> m1;
//
//    private final HashMap<Integer, V> m2;
//
//    public Mapping() {
//        m1 = new HashMap<>();
//        m2 = new HashMap<>();
//    }
//
//    public Mapping(Object... eles) {
//        if (eles == null || eles.length == 0) {
//            throw new RuntimeException("elements cannot be null");
//        }
//        if (eles.length % 2 == 1) {
//            throw new RuntimeException("elements must be even number");
//        }
//        Map<String, Object> map = new HashMap<>((eles.length + 1) / 2);
//        final int step = 2;
//        for (int i = 0; i < eles.length; i += step) {
//            Object key = eles[i];
//            Object value = null;
//            if (eles.length > i + 1) {
//                value = eles[i + 1];
//            }
//            if (key == null) {
//                map.put(null, value);
//            } else if (key instanceof String) {
//                map.put((String) key, value);
//            } else {
//                throw new ClassCastException(key.getClass() + " can not cast to be String");
//            }
//        }
//        return map;
//    }

}
