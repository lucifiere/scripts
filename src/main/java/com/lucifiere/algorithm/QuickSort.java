package com.lucifiere.algorithm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 快排
 *
 * @author XD.Wang
 * @date 2016/12/23.
 */
public class QuickSort {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 3, 5, 6, 1, 2, 4, 9, 8, 7);
        QuickSort.quickSort(list);
        System.out.println(list);
    }

    private static <T extends Comparable> void quickSort(List<T> list) {
        sort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable> void sort(List<T> list, int low, int high) {
        if (low < high) {
            int pivot = partition(list, low, high);
            sort(list, low, pivot - 1);
            sort(list, pivot + 1, high);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable> int partition(List<T> list, int low, int high) {
        T pivot = list.get(low);
        while (low < high) {
            while (low < high && list.get(high).compareTo(pivot) > -1) {
                high--;
            }
            list.set(low, list.get(high));
            while (low < high && list.get(low).compareTo(pivot) < 1) {
                low++;
            }
            list.set(high, list.get(low));
        }
        list.set(low, pivot);
        System.out.println(list);
        return low;
    }

}
