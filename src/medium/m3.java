package medium;

import java.util.HashMap;

public class m3 {

    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 1;
        for (int j = 0; j < chars.length; j++) {
            HashMap<Character, Integer> map = new HashMap<>();
            map.put(chars[j], 1);
            int count = 1;
            for (int i = j + 1; i < chars.length; i++) {
                if (map.containsKey(chars[i])) {
                    break;
                }
                map.put(chars[i], 1);
                count++;
                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }




    public static void main(String[] args) {
        String s = "abcabcbb";
        int max = lengthOfLongestSubstring(s);
        System.out.println(max);
    }
}
