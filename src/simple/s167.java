package simple;

/**
 * 给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target
 */
public class s167 {

    /**
     * 暴力
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            res[0] = i + 1;
            for (int j = i + 1; j < length; j++) {
                if ((numbers[i] + numbers[j]) == target) {
                    res[1] = j + 1;
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * 左边定住 右边二分查找
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            res[0] = i + 1;
            int tar = target - numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (numbers[mid] < tar) {
                    left = mid + 1;
                } else if (numbers[mid] > tar) {
                    right = mid - 1;
                } else {
                    res[1] = mid + 1;
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * 双指针
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] towSum2(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] numbers = {5, 25, 75};
        int target = 100;
        int[] res = towSum2(numbers, target);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
