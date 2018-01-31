package com.collection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XD.Wang on 2018/1/31.
 * MAP Utils
 */
final public class MapUtils {

    /**
     * 创建String - Obj类型的Map
     *
     * @param objects 参数列表
     * @return 结果
     */
    public static Map<String, Object> createSOMap(Object... objects) {
        if (objects == null) {
            return new HashMap<>(0);
        }
        Map<String, Object> map = new HashMap<>((objects.length + 1) / 2);
        for (int i = 0; i < objects.length; i += 2) {
            Object key = objects[i];
            Object value = null;
            if (objects.length > i + 1) {
                value = objects[i + 1];
            }
            if (key == null) {
                map.put(null, value);
            } else if (key instanceof String) {
                map.put((String) key, value);
            } else {
                throw new ClassCastException(key.getClass() + " can not cast to be String");
            }
        }
        return map;
    }

    /**
     * 根据类型和参数创建一个map
     * 如果类型不匹配则抛出异常
     *
     * @param keyType   键的类型
     * @param valueType 值的类型
     * @param objects   参数
     * @param <K>       key gen
     * @param <V>       value gen
     * @return map
     */
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> createCheckedMap(Class<K> keyType, Class<V> valueType, Object... objects) {
        if (objects == null) {
            return new HashMap<>();
        }
        Map<K, V> map = new HashMap<>((objects.length + 1) / 2);
        for (int i = 0; i < objects.length; i += 2) {
            Object key = objects[i];
            Object value = null;
            if (objects.length > i + 1) {
                value = objects[i + 1];
            }

            if (key != null && !keyType.isAssignableFrom(key.getClass())) {
                throw new ClassCastException(key.getClass() + " can not cast to be " + keyType);
            } else if (value != null && !valueType.isAssignableFrom(value.getClass())) {
                throw new ClassCastException(value.getClass() + " can not cast to be " + valueType);
            }
            map.put((K) key, (V) value);
        }
        return map;
    }

    /**
     * 根据字段给list分组
     *
     * @param list       list
     * @param filedClazz 字段的类型，用做运行时检查
     * @param filed      字段
     * @param <K>        K PO分组依据的字段
     * @param <V>        V PO的类型
     * @return 分组结果
     */
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> groupListByKey(List<V> list, Class<K> filedClazz, String filed) {
        try {
            Map<K, V> res = new HashMap<>();
            if (list != null && list.size() > 0) {
                Field fField = list.get(0).getClass().getDeclaredField(filed);
                if (!filedClazz.isAssignableFrom(fField.getType())) throw new RuntimeException("error key type!");
                fField.setAccessible(true);
                for (V k : list) {
                    Object key = fField.get(k);
                    res.put((K) key, k);
                }
            }
            return res;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("analysis foreign field failed: " + e.getMessage());
        }
    }

}
