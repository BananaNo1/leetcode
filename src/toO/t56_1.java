package toO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class t56 {

    public static int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        map.forEach((k, v) -> {
            if (v == 1) {
                list.add(k);
            }
        });
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // todo 异或
    public static int[] singleNumbers1(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums) {
            n ^= num;
        }
        m = n & (~n + 1);
        for (int num : nums) {
            if ((num & m) != 0) {
                x ^= num;
            }
        }
        y = n ^ x;
        return new int[]{x, y};
    }


    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 6};
        Arrays.stream(singleNumbers1(nums)).forEach(System.out::println);
    }
}
