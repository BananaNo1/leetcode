package nowcoder;

import java.util.Scanner;

public class beiyou4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[1001];
        for (int i = 0; i < n; i++) {
            arr[sc.nextInt()]++;
        }
        int num = sc.nextInt();
        int count = 0;
        int i = 1;
        for (; i <= 1000; i++) {
            if (arr[i] > 0) {
                count++;
            }
            if (count == num) {
                break;
            }
        }
        System.out.println(i);
    }
}
