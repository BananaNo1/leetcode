package medium;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class m189 {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] arr = new int[k];
        int j = 0;
        for (int i = nums.length-k; i < nums.length; i++) {
            arr[j] = nums[i];
            j++;
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];

        }
        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }
    }




    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
