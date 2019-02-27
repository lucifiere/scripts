package com.collection;

import com.google.common.collect.Range;

/**
 * 区间
 *
 * @author user
 */
public class Interval<T extends Comparable> {

    public T start;

    public T end;

    public Interval(T start, T end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + this.start + "-" + this.end + "]";
    }

    public Range<T> toRange() {
        return Range.closed(this.start, this.end);
    }

}
