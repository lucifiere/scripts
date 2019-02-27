package com.collection;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author user
 */
public class IntervalUtils {

    public static void main(String[] args) {
        Interval<Integer> r1 = new Interval<>(1, 2);
        Interval<Integer> r2 = new Interval<>(3, 4);
        Interval<Integer> r3 = new Interval<>(7, 8);
        List<Interval<Integer>> r = Lists.newArrayList(r1, r2, r3);
        System.out.println(merge(r));
    }

    public static List<Interval<Integer>> merge(List<Interval<Integer>> intervals) {
        List<Interval<Integer>> result = new LinkedList<>();
        if (intervals == null || intervals.size() < 1) {
            return result;
        }
        intervals.sort(Comparator.comparingInt(o -> (Integer) o.start));
        Interval<Integer> prev = null;
        for (Interval<Integer> cur : intervals) {
            if (prev == null || prev.end + 1 < cur.start) {
                result.add(cur);
                prev = cur;
            } else if (prev.end < cur.end || cur.start - prev.end == 1) {
                prev.end = cur.end;
            }
        }
        return result;
    }

}
