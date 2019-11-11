package simple;

/**
 * @ClassName IsPalindrome
 * @Description 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @Author leis
 * @Date 2019/7/12 11:02
 * @Version 1.0
 **/
public class IsPalindrome {
    /**
     * 整数转字符串
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String s = x + "";
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome1(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }


    public static boolean isPalindrome2(int x) {

        return true;
    }

    public static void main(String[] args) {
        int x = 1221;
        System.out.println(isPalindrome(x));
    }
}
