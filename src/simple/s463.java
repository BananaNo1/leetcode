package simple;

public class s463 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx < 0 || tx >= row || ty < 0 || ty >= col || grid[tx][ty] == 0) {
                            count += 1;
                        }
                    }
                    ans += count;
                }
            }
        }
        return ans;
    }

    public static int islandPerimeter1(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    ans += dfs(i, j, grid, row, col);
                }
            }
        }
        return ans;
    }


    public static int dfs(int x, int y, int[][] grid, int n, int m) {
        if (x < 0 || x >= n || y >= 0 || y >= m || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            return 0;
        }
        grid[x][y] = 2;
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx, ty, grid, n, m);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
