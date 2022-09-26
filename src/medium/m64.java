package medium;

public class m64 {

    // m1
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int l = dp[i - 1][j] + grid[i][j];
                int d = dp[i][j - 1] + grid[i][j];
                dp[i][j] = Math.min(l, d);
            }
        }
        return dp[m - 1][n - 1];
    }

    //m2
    public static int minPathSum1(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(arr));
    }
}
