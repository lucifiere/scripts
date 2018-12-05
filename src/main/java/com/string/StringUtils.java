package com.string;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.util.List;

/**
 * Created by XD.Wang on 2018/1/31.
 * 常用字符串工具类
 */
final public class StringUtils {

    private StringUtils() {
    }

    /**
     * 拼接入库ID
     *
     * @param id  ID
     * @param <T> T
     * @return 拼接结果
     */
    public static <T> String joinID(List<T> id) {
        Joiner joiner = Joiner.on(",").skipNulls();
        return joiner.join(id);
    }

    /**
     * 按照分隔符拼接
     *
     * @param id  ID
     * @param sep 分隔符
     * @param <T> T
     * @return 拼接结果
     */
    public static <T> String join(List<T> id, String sep) {
        Joiner joiner = Joiner.on(sep).skipNulls();
        return joiner.join(id);
    }

    /**
     * 分隔字符串
     *
     * @param source 源字符串
     * @return 字符串数组
     */
    public static List<String> split(String source) {
        Splitter splitter = Splitter.on(",").omitEmptyStrings();
        return splitter.splitToList(source);
    }

    /**
     * 将字符串的首字母大写
     *
     * @param str 字符串
     * @return 首字母大写的字符串
     */
    static String capitalFirst(String str) {
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(str)) {
            char[] cs = str.toCharArray();
            cs[0] = (char) (((int) cs[0]) - 32);
            return String.valueOf(cs);
        }
        return str;
    }

}
