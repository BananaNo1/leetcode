package toO;

import java.util.Arrays;

public class t57_1 {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int s = nums[l] + nums[r];
            if (s < target) {
                l++;
            } else if (s > target) {
                r--;
            } else {
                return new int[]{nums[l], nums[r]};
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] nums = {10, 26, 30, 31, 47, 60};
        int target = 40;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
    }
}
