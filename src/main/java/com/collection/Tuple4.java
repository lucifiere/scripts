package com.collection;

/**
 * 四元组工具类
 *
 * @param <A>
 * @param <B>
 * @author XD.Wang
 */
public class Tuple4<A, B, C, D> {

    public final A first;

    public final B second;

    public final C third;

    public final D fourth;

    public Tuple4(A a, B b, C c, D d) {
        first = a;
        second = b;
        third = c;
        fourth = d;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ")";
    }

}
