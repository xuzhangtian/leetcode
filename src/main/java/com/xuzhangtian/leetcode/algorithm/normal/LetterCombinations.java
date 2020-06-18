package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * Created xzt.
 * Date : 2020/6/12
 * Time : 5:03 下午
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinations {


    public static void main(String[] args) {
        String a = "";
        List<String> arrs = letterCombinations(a);
        arrs.forEach(System.out::println);
    }

    public static List<String> letterCombinations(String digits) {
        Map<String, String[]> numMaps = new HashMap<>();
        numMaps.put("2", new String[]{"a", "b", "c"});
        numMaps.put("3", new String[]{"d", "e", "f"});
        numMaps.put("4", new String[]{"g", "h", "i"});
        numMaps.put("5", new String[]{"j", "k", "l"});
        numMaps.put("6", new String[]{"m", "n", "o"});
        numMaps.put("7", new String[]{"p", "q", "r", "s"});
        numMaps.put("8", new String[]{"t", "u", "v"});
        numMaps.put("9", new String[]{"w", "x", "y", "z"});
        List<String> output = new ArrayList<>();
        backtrack(output, numMaps, "", digits);
        return output;
    }

    public static void backtrack(List<String> output, Map<String, String[]> numMaps, String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            if (!"".equals(combination))
                output.add(combination);
        } else {
            String key = nextDigits.substring(0, 1);
            nextDigits = nextDigits.substring(1);
            String[] values = numMaps.get(key);
            for (String value : values) {
                backtrack(output, numMaps, combination + value, nextDigits);
            }
        }
    }

}
