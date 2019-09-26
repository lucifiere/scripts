package com.lucifiere.algorithm;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * @author XD.Wang
 * @date 2016/12/23.
 */
public class IntRevert {

    public static void main(String[] args) {
        System.out.println(revert(10));
        System.out.println(revert(345));
        System.out.println(revert(9872));
        System.out.println(revert(2147483647));
    }

    private static long revert(long x) {
        // 反转后的数
        long n = 0;
        while (x != 0) {
            // 积累出反转后的数：原数上一位的数实际表示的值 + 原数当前位的值
            long newrpc = n * 10 + x % 10;
            //
            if ((newrpc - x % 10) / 10 != n) {
                return 0;
            }
            // 本轮积累结果记录下来，继续去下一位数
            System.out.println(newrpc);
            n = newrpc;
            // 舍弃掉已经积累过的位数
            x = x / 10;
        }
        return n;
    }

}
