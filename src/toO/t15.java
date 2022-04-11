package toO;

public class t15 {


    public static int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            n = n & (n - 1);
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(5));
    }
}
