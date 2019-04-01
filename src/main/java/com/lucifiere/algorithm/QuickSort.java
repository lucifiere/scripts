package com.lucifiere.algorithm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 快速排序
 * 快速排序一般基于递归实现。其思路是这样的：
 * 1.选定一个合适的值（理想情况中值最好，但实现中一般使用数组第一个值）,称为“枢轴”(pivot)。
 * 2.基于这个值，将数组分为两部分，较小的分在左边，较大的分在右边。
 * 3.可以肯定，如此一轮下来，这个枢轴的位置一定在最终位置上。
 * 4.对两个子数组分别重复上述过程，直到每个数组只有一个元素。
 * 5.排序完成。
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
