package simple;

import java.util.ArrayList;
import java.util.List;

public class s228 {

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            list.add(temp.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> list = summaryRanges(nums);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
