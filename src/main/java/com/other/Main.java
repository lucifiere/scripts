package com.other;

import com.collection.MapUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by XD.Wang on 2018/1/31.
 * 测试
 */
public class Main {

    public static void main(String[] args) {
        List<Pojo> test = Arrays.asList(
                new Pojo(1L, "xxx1", 1, 0.5F),
                new Pojo(2L, "xxx2", 1, 0.6F),
                new Pojo(3L, "xxx3", 1, 0.7F),
                new Pojo(4L, "xxx4", 1, 0.8F));
        Map<Long, Pojo> map = MapUtils.groupListByKey(test, Long.class, "id");
        Map<Long, Pojo> map2 = MapUtils.groupListByKey(test, Long.class, "filed1");
        System.out.println(map2.get("xxx2").getFiled1());
        System.out.println(map.get(1L).getFiled1());
    }

}
