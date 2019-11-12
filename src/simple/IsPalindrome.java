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
     * 整数转字符串(low)
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

    /**
     * 首位和末位相比较
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    /**
     * 反转一半
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int result = 0;
        while (result < x) {
            int p = x % 10;
            result = result * 10 + p;
            x /= 10;
        }
        return x == result || x == result / 10;
    }

    public static void main(String[] args) {
        int x = 10;
        System.out.println(isPalindrome2(x));
    }
}
