package toO;

public class t16 {

    // timeout
    public static double myPow(double x, int n) {
        if (x == 1)
            return 1.0;
        long b = n;
        long a = Math.abs(b);
        double res = 1;
        for (int i = 0; i < a; i++) {
            res = res * x;
        }
        if (n < 0)
            return 1.0 / res;
        return res;
    }

    //3的11次方  快速幂的思想就是将指数11 可以转成二进制数1011
    public static double myPow1(double x, int n) {
        if (x == 0)
            return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(myPow1(2, 3));
    }
}
