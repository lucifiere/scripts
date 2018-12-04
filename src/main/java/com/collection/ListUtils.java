package com.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 列表工具类
 *
 * @author XD.Wang
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

    /**
     * 均分List
     *
     * @param source 待均分的的List
     * @param size   每片的大小
     * @param <T>    T
     * @return 均分后的结果
     */
    public static <T> List<List<T>> splitList(List<T> source, int size) {
        List<List<T>> listArr = new ArrayList<>();
        int arrSize = source.size() % size == 0 ? source.size() / size : source.size() / size + 1;
        for (int i = 0; i < arrSize; i++) {
            List<T> sub = new ArrayList<>();
            for (int j = i * size; j <= size * (i + 1) - 1; j++) {
                if (j <= source.size() - 1) {
                    sub.add(source.get(j));
                }
            }
            listArr.add(sub);
        }
        return listArr;
    }

    public static void main(String[] args) {
        List<Integer> seq = Stream.iterate(1, item -> item + 1).limit(2311).collect(Collectors.toList());
        List<List<Integer>> seqList = ListUtils.splitList(seq, 1000);
        seqList.forEach(System.out::println);
    }

}
