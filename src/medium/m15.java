package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class m15 {

    //m1 暴力 没有去重
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    }
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    while (j < k && nums[j] == nums[++j]) ;
                } else if (sum > 0) {
                    while (j < k && nums[k] == nums[--k]) ;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while (j < k && nums[j] == nums[++j]) ;
                    while (j < k && nums[k] == nums[--k]) ;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum1(nums);
        lists.forEach(list -> {
            list.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
    }
}
