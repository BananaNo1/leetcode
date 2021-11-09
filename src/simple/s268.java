package simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class s268 {


    public static int missingNumber(int[] nums) {
        int[] arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                return i;
        }
        return 0;
    }


    public static int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        } else if (nums[0] != 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            int expectNum = nums[i - 1] + 1;
            if (nums[i] != expectNum) {
                return expectNum;
            }
        }
        return -1;
    }

    public static int missingNumber2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums)
            numSet.add(num);
        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }


    public static int missingNumber3(int[] nums) {


        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println(missingNumber(nums));
    }
}
