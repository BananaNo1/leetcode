package nowcoder;

import java.util.Scanner;

public class beiyou1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int i = sc.nextInt();
            String result = count(i);
            result = new StringBuilder(result).reverse().toString();
            System.out.println(result);
        }
    }

    public static String count(int num) {
        String result = "";
        while (num > 0) {
            int i = num % 2;
            num = num / 2;
            result = result + i;
        }
        return result;
    }

}
