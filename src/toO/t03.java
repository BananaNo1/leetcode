package toO;

import java.util.HashSet;
import java.util.Set;

public class t03 {

    public int findRepeatNumber(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[nums[i]]++;
            if (ans[nums[i]] > 1) {
                return nums[i];
            }
        }
        return 0;
    }

    public int findRepeatNumber1(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        for (int num : nums) {
            if (ans.contains(num))
                return num;
            ans.add(num);
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i == nums[i]) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
