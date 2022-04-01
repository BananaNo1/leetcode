package medium;

public class m29 {

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = -1;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        int res = div(a, b);
        if (sign > 0) {
            return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res;
        }
        return -res;
    }

    public static int div(long a, long b) {
        if (a < b) {
            return 0;
        }
        int count = 1;
        long tb = b;
        while ((tb + tb) <= a) {
            count = count + count;
            tb = tb + tb;
        }
        return count + div(a - tb, b);
    }

    public static void main(String[] args) {
        System.out.println(divide(7, -3));
    }
}
