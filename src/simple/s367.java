package simple;

public class s367 {

    public boolean isPerfectSquare(int num) {
        int res = (int) Math.sqrt(num);
        return res * res == num;
    }

    public boolean isPerfectSquare1(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
