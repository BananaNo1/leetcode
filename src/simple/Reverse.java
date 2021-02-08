package simple;

/**
 * @ClassName Reverse
 * @Description 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * @Author leis
 * @Date 2019/7/12 10:46
 * @Version 1.0
 **/
public class Reverse {

    public static int reverse(int x) {
        if (x == 0) {
        return 0;
    } else if (x > 0) {
        return rese(x);
    } else {
        int result = rese(Math.abs(x));
        if (result == 0) {
            return 0;
        }
        String s = "-" + result;
        return Integer.parseInt(s);
    }
}

    public static int rese(int x) {
        StringBuffer sb = new StringBuffer(x + "");
        String s = sb.reverse().toString();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' == 0) {
                count++;
            }
            break;
        }
        if (count != 0) {
            s = s.substring(count - 1);
        }
        try {
            int result = Integer.parseInt(s);
            return result;
        } catch (Exception e) {
            return 0;
        }
    }


    public static int reverse1(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = -1230000;
        System.out.println(reverse(a));
    }
}
