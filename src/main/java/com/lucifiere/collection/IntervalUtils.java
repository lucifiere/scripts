package com.lucifiere.collection;

import com.google.common.collect.Lists;
import com.lucifiere.entity.Interval;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * 区间工具
 *
 * @author XD.Wang
 */
public class IntervalUtils {

    public static void main(String[] args) {
        Interval<Integer> r1 = new Interval<>(1, 2);
        Interval<Integer> r2 = new Interval<>(3, 4);
        Interval<Integer> r3 = new Interval<>(7, 8);
        List<Interval<Integer>> r = Lists.newArrayList(r1, r2, r3);
        System.out.println(merge(r));
    }

    /**
     * 闭区间合并
     * 如[1-2]和[2-3]可以合并为[1-3]；[4-5]和[6-7]可以合并成[4-7]
     *
     * @param intervals 待合并区间
     * @return 合并结果
     */
    public static List<Interval<Integer>> merge(List<Interval<Integer>> intervals) {
        Stack<Interval<Integer>> result = new Stack<>();
        if (intervals == null || intervals.size() < 1) {
            return result;
        }
        intervals.sort(Comparator.comparingInt(o -> (Integer) o.start));
        Interval<Integer> prev = null;
        for (Interval<Integer> cur : intervals) {
            if (prev == null || prev.end + 1 < cur.start) {
                result.push(cur);
                prev = cur;
            } else if (prev.end < cur.end || cur.start - prev.end == 1) {
                result.pop();
                prev = new Interval<>(prev.start, cur.end);
                result.push(prev);
            }
        }
        return result;
    }

}
