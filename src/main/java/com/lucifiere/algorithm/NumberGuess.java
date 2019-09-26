package com.lucifiere.algorithm;

/**
 * 整数反转
 * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
 * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
 * 难度：✨
 *
 * @author XD.Wang
 * @date 2019/09/23.
 */
public class NumberGuess {

    public static void main(String[] args) {
        System.out.println(game(new int[]{1, 2, 3}, new int[]{1, 1, 2}));
    }

    public static int game(int[] guess, int[] answer) {
        int right = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                right++;
            }
        }
        return right;
    }

}
