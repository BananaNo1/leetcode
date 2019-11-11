package simple;

/**
 * @ClassName SearchInsert
 * @Description 给定一个排序数组和一个目标值，在数组中找到目标值，
 * 并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @Author leis
 * @Date 2019/7/18 16:20
 * @Version 1.0
 **/
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length <= 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int target1 = 7;
        System.out.println(searchInsert(nums, target));
        System.out.println(searchInsert(nums, target1));
    }
}
