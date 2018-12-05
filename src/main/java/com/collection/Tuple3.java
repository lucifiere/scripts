package com.collection;

/**
 * Created by XD.Wang on 2017/7/11.
 * 三元组
 *
 * @param <A> 第一个元素
 * @param <B> 第二个元素
 * @param <C> 第三个元素
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
