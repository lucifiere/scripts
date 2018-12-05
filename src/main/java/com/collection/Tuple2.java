package com.collection;

/**
 * Created by XD.Wang on 2017/7/11.
 * 二元组
 *
 * @param <A> 第一个元素
 * @param <B> 第二个元素
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
