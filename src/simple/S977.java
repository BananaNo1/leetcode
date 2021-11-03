package simple;

import java.util.Arrays;

public class S977 {

    public static int[] sortedSquares1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int s = 0;
        int e = nums.length - 1;



        return null;
    }


    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        sortedSquares1(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
