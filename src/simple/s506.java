package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class s506 {

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            if (i >= 3) {
                ans[arr[i][1]] = Integer.toString(i + 1);
            } else {
                ans[arr[i][1]] = desc[i];
            }
        }
        return ans;
    }


    static String[] ss = {"Gold Medal", "Silver Medal", "Bronze Medal"};

    public static String[] findRelativeRanks1(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        int[] clone = score.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            map.put(clone[i], n - 1 - i);
        }

        for (int i = 0; i < n; i++) {
            int rank = map.get(score[i]);
            ans[i] = rank < 3 ? ss[rank] : String.valueOf(rank + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] score = {10, 3, 8, 9, 4};
        String[] ans = findRelativeRanks(score);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
