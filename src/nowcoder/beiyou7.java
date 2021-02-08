package nowcoder;

import java.util.Scanner;

public class beiyou7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int[] arr = new int[10];
        String[] stringsa = a.split("");
        for (String string : stringsa) {
            arr[Integer.parseInt(string)]++;
        }
        String b = sc.nextLine();
        int length = b.length();
        String[] stringsb = b.split("");
        int[] arr1 = new int[10];
        for (String string : stringsb) {
            arr1[Integer.parseInt(string)]++;
        }
        int i = 0;
        for (; i < 10; i++) {
            if (arr1[i] > 0) {
                break;
            }
        }
        boolean tag = false;
        if (length == 1) {
            for (int j = i; j < 10; j++) {
                if (arr[j] > 0) {
                    tag = true;
                    break;
                }
            }
        } else if (length == 2) {
            for (int j = i; j < 10; j++) {
                if (arr[j] > 1) {
                    tag = true;
                    break;
                }
            }

        } else if (length == 3) {
            for (int j = i; j < 10; j++) {
                if (arr[j] > 2) {
                    tag = true;
                    break;
                }
            }

        } else if (length == 4) {
            for (int j = i; j < 10; j++) {
                if (arr[j] > 3) {
                    tag = true;
                    break;
                }
            }

        } else {
            int count = 0;
            for (int j = i + 1; j < 10; j++) {
                if (arr[j] > 0) {
                    count++;
                    if (count >= 5) {
                        tag = true;
                        break;
                    }
                } else {
                    count = 0;
                }
            }
        }
        if (tag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
