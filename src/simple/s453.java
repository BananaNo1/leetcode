package simple;

import java.util.Arrays;

public class s453 {


    public static int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(minMoves(nums));
    }
}
