package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created xzt.
 * Date : 2020/6/18
 * Time : 2:32 下午
 */
public class GenerateParenthesis {

    static List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        generateParenthesis(3);
        System.out.println(results);
    }

    public static List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return results;
    }

    public static void dfs(int left, int right, String comb) {
        if (left == 0 && right == 0) {
            results.add(comb);
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, comb + "(");
        }
        if (right > left) {
            dfs(left, right - 1, comb + ")");
        }
    }

}
