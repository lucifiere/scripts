package com.lucifiere.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 难度：✨
 *
 * @author XD.Wang
 * @date 2016/12/23.
 */
public class StoneAndJewel {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("sadsa", "sadsadsadas"));
        System.out.println(numJewelsInStones0("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones0("", "aAAbbbb"));
    }

    public static int numJewelsInStones(String j, String s) {
        char[] stoneArr = s.toCharArray();
        char[] jewelArr = j.toCharArray();
        int count = 0;
        for (char c1 : stoneArr) {
            for (char c : jewelArr) {
                if (c1 == c) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int numJewelsInStones0(String j, String s) {
        char[] stoneArr = s.toCharArray();
        char[] jewelArr = j.toCharArray();
        Set<Character> jewelSet = new HashSet<>();
        for (char i : jewelArr) {
            jewelSet.add(i);
        }
        int count = 0;
        for (char c1 : stoneArr) {
            if (jewelSet.contains(c1)) {
                count++;
            }
        }
        return count;
    }

}
