package toO;

public class t14_1 {

    public static int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }

    public static int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                int tmp = Math.max(dp[j] * (i - j), j * (i - j));
                dp[i] = Math.max(tmp, dp[i]);
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(cuttingRope(10)); //36
        System.out.println(cuttingRope(11)); //54
    }
}
