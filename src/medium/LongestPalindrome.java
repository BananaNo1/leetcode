package medium;

/**
 * @ClassName LongestPalindrome
 * @Description 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @Author leis
 * @Date 2019/11/18 18:36
 * @Version 1.0
 **/
public class LongestPalindrome {
    public String longestPalindrome1(String s) {
        String res = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindrome1(test) && test.length() > max) {
                    max = test.length();
                    res = s.substring(i, j);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome1(String test) {
        int len = test.length();
        for (int i = 0; i < len / 2; i++) {
            if (test.charAt(i) != test.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = isPalindrome2(s, i, i);
            int len2 = isPalindrome2(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int isPalindrome2(String s, int start, int end) {
        int left = start;
        int right = end;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome2(s));
    }
}
