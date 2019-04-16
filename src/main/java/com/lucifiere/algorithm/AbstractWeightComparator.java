package com.lucifiere.algorithm;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 多条件权重排序
 *
 * @author XD.Wang
 * @date 2018/11/02.
 */
public abstract class AbstractWeightComparator<T> implements Comparator<T> {

    /**
     * 斐波那契数列生成器
     * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233，
     * 377，610，987，1597，2584，4181，6765，10946，17711，28657，
     * 46368...
     */
    class FibonacciSupplier implements Supplier<Long> {

        long a = 0;
        long b = 1;

        @Override
        public Long get() {
            long x = a + b;
            a = b;
            b = x;
            return a;
        }

    }

    private Iterator<Long> fibonacciItr = Stream.generate(new FibonacciSupplier()).iterator();

    protected Long nextWeight() {
        return fibonacciItr.next();
    }

    protected Long firstWeight() {
        return fibonacciItr.next();
    }

    private long o1Weight;

    private long o2Weight;

    @Override
    public int compare(T o1, T o2) {
        Long o1Weight = get1stWeight(o1);
        Long o2Weight = get2ndWeight(o2);
        return o1Weight.compareTo(o2Weight);
    }

    /**
     * 获取第一个元素的权值
     *
     * @param o 元素
     * @return 权重
     */
    protected abstract long get1stWeight(T o);

    /**
     * 获取第二个元素的权值
     *
     * @param o 元素
     * @return 权重
     */
    protected abstract long get2ndWeight(T o);

}
