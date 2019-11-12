package simple;

/**
 * @ClassName AddBinary
 * @Description 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * @Author leis
 * @Date 2019/11/12 17:38
 * @Version 1.0
 **/
public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        int is = 0;
        while (len1 >= 0 || len2 >= 0) {
            int sum = is;
            sum += (len1 >= 0 ? a.charAt(len1) - '0' : 0);
            sum += (len2 >= 0 ? b.charAt(len2) - '0' : 0);
            sb.append(sum % 2);
            is = sum / 2;
            len1--;
            len2--;
        }
        if (is == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1011";
        String b = "1010";
        System.out.println(addBinary(a, b));
    }
}
