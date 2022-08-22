package nowcoder.alg;

import com.sun.xml.internal.bind.v2.util.StackRecorder;

public class BM17 {


    public static int search(int[] nums, int target) {
        // write code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
//            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] nums = {-1, 0, 3, 4, 6, 10, 13, 14};
        System.out.println(search(nums, 13));
    }
}
