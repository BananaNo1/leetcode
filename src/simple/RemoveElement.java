package simple;

/**
 * @ClassName RemoveElement
 * @Description 移除元素
 * @Author leis
 * @Date 2019/7/12 17:03
 * @Version 1.0
 **/
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {

      /*  int i = 0;
        int j = nums.length - 1;
        int count = 0;
        while (i < j) {
            while (nums[i] != val && i < nums.length - 1) {
                i++;
                count++;
            }
            while (nums[j] == val && j > 0) {
                j--;
            }
            if (i < j) {
                int tem = nums[j];
                nums[j] = nums[i];
                nums[i] = tem;
            }
        }*/

//        int i = 0;
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[j] != val) {
//                nums[i] = nums[j];
//                i++;
//            }
//        }
//        return i;

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {2};
        int val = 3;
        System.out.println(removeElement(nums, val));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
