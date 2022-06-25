package toO;

import java.util.LinkedList;
import java.util.List;

public class t57_2 {

    public static int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new LinkedList<>();
        while (i < j) {
            if (s == target) {
                int[] ans = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    ans[k - i] = k;
                }
                res.add(ans);
            }
            if (s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }


    public static void main(String[] args) {

    }
}
