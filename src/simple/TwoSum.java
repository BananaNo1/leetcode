package simple;

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum1(int[] nums, int target) {
        int[] array =new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            array[0]  = i;
            int result = target-nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if( result == nums[j]) {
                    array[1] = j;
                    return array;
                }
            }
        }
        return array;
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int need = target - nums[i];
            if(map.containsKey(need) && map.get(need) != i){
                return new int[]{i,map.get(need)};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;
        int[] ints = twoSum1(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
