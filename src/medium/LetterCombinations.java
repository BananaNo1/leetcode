package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LetterCombinations
 * @Description 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @Author leis
 * @Date 2019/12/18 11:17
 * @Version 1.0
 **/
public class LetterCombinations {
    /**
     * 2 abc
     * 3 def
     * 4 ghi
     * 5 jkl
     * 6 mno
     * 7 pqrs
     * 8 tuv
     * 9 wxyz
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backTrack("", digits);
        }
        return result;
    }

    public static void backTrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            result.add(combination);
        } else {
            String digit = nextDigits.substring(0, 1);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = map.get(digit).substring(i, i + 1);
                backTrack(combination + letter, nextDigits.substring(1));
            }
        }
    }

    public static List<String> result = new ArrayList<>();
    public static Map<String, String> map = new HashMap<>();

    static {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }

    public static void main(String[] args) {
        letterCombinations("23");
        System.out.println(result);
    }
}
