package simple;

public class s342 {


    public static boolean isPowerOfThree(int n) {
        while (n != 0 && n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(isPowerOfThree(n));
    }
}
