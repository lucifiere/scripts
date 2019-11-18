package com.lucifiere.algorithm;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 回溯实现
 * 难度：✨✨✨
 *
 * @author XD.Wang
 * @date 2016/12/23.
 */
public class Permutation {

    public static void main(String[] args) {
        List<Integer> ll = Lists.newArrayList(1, 2, 3, 4);
        System.out.println(permute(ll));
    }

    public static List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.size()];
        backtrack(res, nums, new ArrayList<>(), visited);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.size()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums.get(i));
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

}
