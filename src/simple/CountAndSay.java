package simple;

/**
 * @ClassName CountAndSay
 * @Description 下一个数是对前一个数的解释
 * @Author leis
 * @Date 2019/7/18 16:33
 * @Version 1.0
 **/
public class CountAndSay {

    public static String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            for (int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == pre) {
                    count++;
                } else {
                    builder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            builder.append(count).append(pre);
            str = builder.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
