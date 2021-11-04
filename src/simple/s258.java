package simple;

public class s258 {

    public static int addDigits(int num) {
        while (true) {
            int sum = 0;
            while (num > 0) {
                int n = num % 10;
                sum = sum + n;
                num = num / 10;
            }
            if (sum < 10) {
                return sum;
            } else {
                num = sum;
            }
        }
    }

    public static int addDigits1(int num) {
        return (num - 1) % 9 + 1;
    }


    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }
}
