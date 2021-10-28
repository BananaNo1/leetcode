package simple;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class s190 {

    public static int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(0b11111111111111111111111111111101));
    }


}
