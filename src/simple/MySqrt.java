package simple;

/**
 * @ClassName MySqrt
 * @Description 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数
 * @Author leis
 * @Date 2019/11/12 18:04
 * @Version 1.0
 **/
public class MySqrt {

    public static int mySqrt(int x) {
        int min = 1;
        int max = x;
        while (min < max) {
            int mid = min + (max - min) / 2 + 1;
            if (mid <= x / mid) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        return max;
    }

    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(9));
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(search(nums, 6));
    }
}
