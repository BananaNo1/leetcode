package zuo.c2;


public class t1 {
    /**
     * 奇数次
     * 数组 []
     * 1. 一种数 出现奇数次 其他偶数次
     * <p>
     * 2. 两种数 奇数次  其他偶数次
     */

    public static void solution1(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        System.out.println(res);
    }

    public static void solution2(int[] arr) {
        int eor = 0;
        for (int num : arr) {
            eor ^= num;
        }
        // eor = a ^ b 必然有一个位置上是1
        int rightOne = eor & (~eor + 1); // 提取最右侧的1
        int onlyOne = 0;
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 3};
        solution1(arr1);
    }

}
