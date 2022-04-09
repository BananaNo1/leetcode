package toO;

public class t10 {

    // timeout
    public static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2);

    }

    public static int fib1(int n) {
        int MOD = 1000000007;
        if (n < 2)
            return n;
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }


    public static void main(String[] args) {
        System.out.println(fib1(3));
    }
}
