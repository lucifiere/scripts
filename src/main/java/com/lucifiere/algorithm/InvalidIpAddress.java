package com.lucifiere.algorithm;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 难度：✨
 *
 * @author XD.Wang
 * @date 2016/12/23.
 */
public class InvalidIpAddress {

    public static void main(String[] args) {
        System.out.println(defangIPaddr("112.33.22.123"));
        System.out.println(defangIPaddr0("112.33.22.123"));
    }

    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static String defangIPaddr0(String address) {
        StringBuilder sb = new StringBuilder(address);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '.') {
                sb.insert(i, "[");
                sb.insert(i + 2, "]");
                i = i + 2;
            }
        }
        return sb.toString();
    }

}
