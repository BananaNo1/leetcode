package toO;

public class t101 {
    /**
     * 跳台阶
     *
     * @param n
     * @return
     */
    public static int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1 || n == 2)
            return n;
        return numWays(n - 1) + numWays(n - 2);
    }

    public static int numWays1(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int dp1 = 1, dp2 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = (dp1 + dp2) % 1000000007;
            dp1 = dp2;
            dp2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numWays1(7));
    }
}
