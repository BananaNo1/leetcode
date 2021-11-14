package simple;

public class s326 {
    
    public static boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int n = 32;
        System.out.println(isPowerOfThree(n));
    }
}
