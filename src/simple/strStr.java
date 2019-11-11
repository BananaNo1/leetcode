package simple;

/**
 * @ClassName strStr
 * @Description 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * @Author leis
 * @Date 2019/7/18 15:00
 * @Version 1.0
 **/
public class strStr {

    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issippi";
        int i = strStr(haystack, needle);
        System.out.println(i);
    }
}
