package simple;

/**
 * @ClassName LengthOfLastWord
 * @Description 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * @Author leis
 * @Date 2019/11/11 17:18
 * @Version 1.0
 **/
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

    public static int lengthOfLastWord1(String s) {
        s = s.trim();
        int end = s.length() - 1;
        if (end == 1) {
            return 1;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

    public static void main(String[] args) {
        String s = "a ";
        String s1 = "Hello World";
        String c = "  ";
        System.out.println(lengthOfLastWord1(c));
        System.out.println(lengthOfLastWord1(s));
        System.out.println(lengthOfLastWord1(s1));
    }
}
