package toO;

import java.util.LinkedList;
import java.util.Queue;

public class t13 {

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }


    public static int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i >= m || j >= n || calK(i, j) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
    }

    public static int calK(int m, int n) {
        int sum = 0;
        while (m != 0) {
            sum = sum + m % 10;
            m = m / 10;
        }
        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }


    public static int movingCount1(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();

        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; i++) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || calK(tx, ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
    }
}
