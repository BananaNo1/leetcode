package toO;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class t60 {

    public static boolean isStraight(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                count++;
                continue;
            }
            if (nums[i] == nums[i + 1] - 1) {
                continue;
            } else if (nums[i + 1] == nums[i]) {
                return false;
            } else {
                count = count - (nums[i + 1] - nums[i] - 1);
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }


    public static boolean isStraight1(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) {
                return false;
            }
            repeat.add(num);
        }
        return max - min < 5;
    }

    public static boolean isStraight2(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                joker++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[joker] < 5;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 2, 2, 5};
        System.out.println(isStraight(nums));
    }
}
