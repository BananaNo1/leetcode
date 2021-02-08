package nowcoder;

import java.util.Scanner;

public class beiyou6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[][] arr = new int[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            int b1 = sc.nextInt();
            int b2 = sc.nextInt();
            if (a1 == 1 && a2 == 2) {
                arr = reverse(arr, true, b1 - 1, b2 - 1, 2);
            } else if (a1 == 1 && a2 == 3) {
                arr = reverse(arr, true, b1 - 1, b2 - 1, 3);
            } else if (a1 == 2 && a2 == 2) {
                arr = reverse(arr, false, b1 - 1, b2 - 1, 2);
            } else if (a1 == 2 && a2 == 3) {
                arr = reverse(arr, false, b1 - 1, b2 - 1, 3);
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println(arr[i][4]);
            }
        }
    }

    public static int[][] reverse(int[][] arr, boolean tag, int i, int j, int n) {
        int[] a = new int[n * n];
        int count = 0;
        int k = i + n - 1;
        int l = j + n;

        for (; k >= i; k--) {
            for (int m = j; m < l; m++) {
                a[count++] = arr[k][m];
            }
        }
        count = 0;
        k = i + n - 1;
        if (tag) {
            for (; j < l; j++) {
                for (int m = i; m <= k; m++) {
                    arr[m][j] = a[count++];
                }
            }
        } else {
            for (l=l-1;  l>=j; l--) {
                for (int m = k; m >=i; m--) {
                    arr[m][l] = a[count++];
                }
            }
        }
//        for (int m = 0; m < a.length; m++) {
//            System.out.print(a[m] + " ");
//        }
//        System.out.println();
        return arr;
    }
}
