package com.collection;

/**
 * 二元组工具类
 *
 * @param <A>
 * @param <B>
 * @author XD.Wang
 */
public class Tuple2<A, B> {

    public final A first;

    public final B second;

    public Tuple2(A a, B b) {
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

}
