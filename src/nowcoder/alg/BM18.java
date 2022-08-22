package nowcoder.alg;

public class BM18 {

    public boolean Find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int row = 0;
        int col = array[0].length-1;
        while (row < array.length && col >= 0) {
            if (array[row][col] > target) {
                col--;
            } else if (array[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
