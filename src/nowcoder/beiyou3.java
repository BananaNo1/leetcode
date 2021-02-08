package nowcoder;

import java.util.Scanner;

public class beiyou3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int result = sc.nextInt();
            if (result % 2 == 0) {
                count++;
            } else {
                count--;
            }
        }
        if (count > 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

}
