package simple;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */


public class s283 {

    public static void moveZeroes(int[] nums) {
        int p1 = 0, p2;
        while (p1 < nums.length) {
            while (p1 < nums.length && nums[p1] != 0) {
                p1++;
                if (p1 == nums.length)
                    return;
            }
            if (p1 == nums.length - 1)
                return;
            p2 = p1 + 1;
            while (p2 < nums.length && nums[p2] == 0) {
                p2++;
                if (p2 == nums.length)
                    return;
            }
            swap(nums, p1, p2);
        }
    }

    public void moveZeroes1(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void moveZeroes2(int[] nums) {
        if (null == nums) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }


    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {1};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
