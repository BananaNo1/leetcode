package nowcoder;

import java.util.Scanner;

public class beiyou5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        arr = count(arr, arr, k);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(arr[i][n - 1]);
        }
    }

    public static int[][] count(int[][] arr1, int[][] arr2, int k) {
        if (k <= 1) {
            return arr1;
        }
        int[][] a = new int[arr1.length][arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                int result = 0;
                for (int n = 0; n < arr1.length; n++) {
                    result = result + arr1[i][n] * arr2[n][j];
                }
                a[i][j] = result;
            }
        }
        return count(a, arr2, --k);
    }
}
