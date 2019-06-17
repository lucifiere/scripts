package com.lucifiere.algorithm;

import com.lucifiere.collection.Tuple2;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 多条件权重排序
 *
 * @author XD.Wang
 * @date 2018/11/02.
 */
public abstract class AbstractWeightComparator<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        Tuple2<Long, Long> weightTuples = getWeights(o1, o2);
        return weightTuples.first.compareTo(weightTuples.second);
    }

    /**
     * 获取两个元素的权值
     *
     * @param o1 第一个元素
     * @param o2 第二个元素
     * @return 权重（第一个元素的权重，第二个元素的权重）
     */
    protected abstract Tuple2<Long, Long> getWeights(T o1, T o2);

    /**
     * 决定元素排序的权值
     *
     * @param weight    参与排序的权重
     * @param predicate 顺序靠前的元素应该符合的特征
     * @param invert    是否给权值取反（大于0的权值，取反结果为0；0的取反结果为weight的值）
     * @return 判定条件应有的权值
     */
    private long actualWeight(long weight, boolean invert, Predicate<? super Long> predicate) {
        long actualWeight = Stream.of(weight).filter(predicate).findAny().orElse(0L);
        return invert && actualWeight > 0 ? 0 : actualWeight;
    }

    /**
     * 决定元素排序的权值
     *
     * @param weight    参与排序的权重
     * @param predicate 顺序靠前的元素应该符合的特征
     * @return 判定条件应有的权值
     */
    protected long actualWeight(long weight, Predicate<? super Long> predicate) {
        return actualWeight(weight, false, predicate);
    }

    /**
     * 决定元素排序的权值取反（大于0的权值，取反结果为0；0的取反结果为weight的值）
     *
     * @param weight    参与排序的权重
     * @param predicate 顺序靠前的元素应该符合的特征
     * @return 判定条件应有的权值
     */
    protected long actualInvertWeight(long weight, Predicate<? super Long> predicate) {
        return actualWeight(weight, true, predicate);
    }

}
