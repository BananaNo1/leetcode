package medium;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class m62 {

    //m1 timeout
    public static int count = 0;

    public static int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        dfs(m, n, 1, 1);
        return count;
    }

    public static void dfs(int m, int n, int row, int col) {
        if (row == m && col == n) {
            count++;
            return;
        }
        if (row > m || col > n) {
            return;
        }
        dfs(m, n, row + 1, col);
        dfs(m, n, row, col + 1);
    }

    //m2
    public static int uniquePaths1(int m, int n) {
        if (m < 2 || n < 2) {
            return 1;
        }
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 0;
        for (int i = 0; i < n - 1; i++) {
            dp[m - 1][i] = 1;
        }
        for (int i = 0; i < m - 1; i++) {
            dp[i][n - 1] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));

    }
}
