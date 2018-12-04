package com.collection;

/**
 * 三元组工具类
 *
 * @param <A>
 * @param <B>
 * @author XD.Wang
 */
public class Tuple3<A, B, C> {

    public final A first;

    public final B second;

    public final C third;

    public Tuple3(A a, B b, C c) {
        first = a;
        second = b;
        third = c;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }

}
