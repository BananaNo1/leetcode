package nowcoder.alg;

public class BM19 {

    public static int findPeakElement(int[] nums) {
        // write code here
        if (nums == null) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            int left = i - 1 > 0 ? nums[i - 1] : Integer.MIN_VALUE;
            int right = i + 1 < nums.length ? nums[i + 1] : Integer.MIN_VALUE;
            if (nums[i] > left && nums[i] > right) {
                return i;
            }
        }
        return -1;
    }

    public static int findPeakElement1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 2, 7, 8, 4};
        System.out.println(findPeakElement(nums));
    }
}
