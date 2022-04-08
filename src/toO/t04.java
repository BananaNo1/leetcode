package toO;

public class t04 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
            return false;
        int column = matrix[0].length;
        int row = matrix.length;
        for (int i = 0; i < row; i++) {
            int left = 0, right = column - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (matrix[i][mid] > target) {
                    right = mid - 1;
                } else if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int column = matrix[0].length;
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        if (column == 0) {
            return false;
        }
        int r = 0, c = column - 1;
        while (r < row && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                r++;
            } else {
                c--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
                {18, 21, 23, 26, 30}};

        System.out.println(findNumberIn2DArray(matrix, 6));
    }
}
