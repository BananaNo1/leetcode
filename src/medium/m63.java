package medium;

public class m63 {

    // 从后往前推
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        if (obstacleGrid[row - 1][col - 1] == 1) {
            dp[row - 1][col - 1] = 0;
        } else {
            dp[row - 1][col - 1] = 1;
        }

        for (int i = row - 2; i >= 0; i--) {
            if (obstacleGrid[i][col - 1] == 1 || obstacleGrid[i + 1][col - 1] == 1 || dp[i + 1][col - 1] == 0) {
                dp[i][col - 1] = 0;
            } else {
                dp[i][col - 1] = 1;
            }
        }

        for (int i = col - 2; i >= 0; i--) {
            if (obstacleGrid[row - 1][i] == 1 || obstacleGrid[row - 1][i + 1] == 1 || dp[row - 1][i + 1] == 0) {
                dp[row - 1][i] = 0;
            } else {
                dp[row - 1][i] = 1;
            }
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    int r = obstacleGrid[i + 1][j] == 1 ? 0 : dp[i + 1][j];
                    int d = obstacleGrid[i][j + 1] == 1 ? 0 : dp[i][j + 1];
                    dp[i][j] = r + d;
                }
            }
        }
        return dp[0][0];
    }

    // 从后往前推
    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n][m];

        dp[n - 1][m - 1] = (obstacleGrid[n - 1][m - 1] == 1) ? 0 : 1;

        for (int i = n - 2; i >= 0; i--) {
            if (obstacleGrid[i][m - 1] == 1 || dp[i + 1][m - 1] == 0) {
                dp[i][m - 1] = 0;
            } else {
                dp[i][m - 1] = 1;
            }
        }

        for (int j = m - 2; j >= 0; j--) {
            if (obstacleGrid[n - 1][j] == 1 || dp[n - 1][j + 1] == 0) {
                dp[n - 1][j] = 0;
            } else {
                dp[n - 1][j] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    // 从前往后推
    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n][m];

        dp[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) {
                dp[0][0] = 0;
            } else {
                dp[0][1] = 1;
            }
        }

        for (int j = 1; j < m; j++) {
            if (obstacleGrid[0][j] == 1 || dp[0][j - 1] == 0) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[n - 1][m - 1];
    }


    //一维数组
    public static int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[m - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] x = {{1}};
        int[][] a = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0}};

        System.out.println(uniquePathsWithObstacles3(arr));
    }

}
