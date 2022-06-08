package simple;

public class s441 {

    public static int arrangeCoins(int n) {
        int i = 1;
        int s = n - i;
        while (s >= (i + 1)) {
            i++;
            s = s - i;
        }
        return i;
    }
    //todo
    public static int arrangeCoins1(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }
}
