package com.lucifiere.entity;

import com.google.common.collect.Range;

/**
 * 区间
 *
 * @author user
 */
public class Interval<T extends Comparable> {

    public final T start;

    public final T end;

    private Range<T> range;

    public Interval(T start, T end) {
        this.start = start;
        this.end = end;
        this.range = Range.closed(this.start, this.end);
    }

    @Override
    public String toString() {
        return "[" + this.start + "-" + this.end + "]";
    }

    public Range<T> getRange() {
        return range;
    }

}
