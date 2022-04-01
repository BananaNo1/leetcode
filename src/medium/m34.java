package medium;

public class m34 {

    public static int[] searchRange1(int[] nums, int target) {
        if (nums == null || nums.length <= 0)
            return new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        while (left < nums.length && left <= right) {
            if (nums[left] < target)
                left++;
            else
                break;

        }
        while (right >= 0 && right >= left) {
            if (nums[right] > target)
                right--;
            else
                break;
        }
        if (left > nums.length - 1 || right < 0 || nums[left] != nums[right])
            return new int[]{-1, -1};
        return new int[]{left, right};
    }


    public static int[] searchRange2(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false) - 1;
        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= target) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        int target = 3;
        int[] res = searchRange1(nums, target);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }
}
