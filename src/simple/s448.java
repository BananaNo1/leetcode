package simple;

import java.util.LinkedList;
import java.util.List;

public class s448 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] bult = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            bult[nums[i]]++;
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i < bult.length; i++) {
            if (bult[i] == 0)
                result.add(i);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
