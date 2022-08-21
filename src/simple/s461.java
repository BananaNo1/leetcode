package simple;

public class s461 {

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static int hammingDistance1(int x, int y) {
        int s = x ^ y;
        int ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }


    public static int hammingDistance2(int x, int y) {
        int s = x ^ y;
        int ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }


    public static void main(String[] args) {
        int x = 3;
        int y = 1;
        System.out.println(hammingDistance1(x, y));

    }
}
