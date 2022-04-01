package nowcoder.toOffer;

public class JZ4 {

    public static boolean Find1(int target, int[][] array) {
        if (array == null || array.length <= 0 || array[0].length <= 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            int left = 0;
            int right = array[0].length - 1;
            if (array[i][0] > target) {
                return false;
            }
            while (left <= right) {
                int mid = (right + left) / 2;
                if (array[i][mid] == target) {
                    return true;
                } else if (array[i][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }


    public static boolean Find2(int target, int[][] array) {
        int m = array.length;
        if (m == 0) {
            return false;
        }
        int n = array[0].length;
        if (n == 0) {
            return false;
        }
        int r = 0, c = n - 1;
        while (r < m && c >= 0) {
            if (target == array[r][c]) {
                return true;
            } else if (target > array[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int[][] arr1 = {{}};
        int target = 3;
        System.out.println(Find1(target, arr1));

    }
}
