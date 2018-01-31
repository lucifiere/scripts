package com.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XD.Wang on 2018/1/31.
 * some list kit
 */
final public class ListUtils {

    /**
     * 移除空值
     *
     * @param list1 list1
     * @param <T>   泛型参数
     */
    public static <T> void removeNullValue(List<T> list1) {
        List<T> list2 = new ArrayList<>();
        list2.add(null);
        list1.removeAll(list2);
    }

}
