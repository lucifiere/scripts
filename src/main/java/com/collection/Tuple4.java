package com.collection;

/**
 * 四元组
 *
 * @param <A> 第一个元素
 * @param <B> 第二个元素
 * @param <C> 第三个元素
 * @param <D> 第四个元素
 * @author XD.Wang
 * @date 2017/7/11.
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
