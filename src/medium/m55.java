package medium;

import java.math.BigDecimal;

public class m55 {

    // m1
    public static boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        boolean[] isVisited = new boolean[nums.length];
        isVisited[0] = true;
        return dfs(nums, 0, isVisited);
    }

    public static boolean dfs(int[] nums, int cur, boolean[] isVisited) {
        if (cur + nums[cur] >= nums.length - 1) {
            return true;
        }
        isVisited[cur] = true;
        for (int i = cur + 1; i <= cur + nums[cur]; i++) {
            if (!isVisited[i] && dfs(nums, i, isVisited)) {
                return true;
            }
        }
        return false;
    }

    // m2
    public static boolean canJump1(int[] nums) {
        if (nums == null) {
            return false;
        }
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost > n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }
}
