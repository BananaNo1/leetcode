package simple;

/**
 * @ClassName ClimbStairs
 * @Description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @Author leis
 * @Date 2019/11/13 17:07
 * @Version 1.0
 **/
public class ClimbStairs {

    //超时
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //尾递归
    public static int climbStairs2(int n) {
        return myClimbStairs(1, 2, n);
    }

    public static int myClimbStairs(int ret1, int ret2, int n) {
        if (n == 1) {
            return ret1;
        }
        return myClimbStairs(ret2, ret1 + ret2, n - 1);
    }

    public static int climbStairs3(int n) {
        if (n < 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int c = n;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }


    public static void main(String[] args) {
        System.out.println(climbStairs1(44));
        System.out.println(climbStairs2(2));
        System.out.println(climbStairs3(44));
    }
}
