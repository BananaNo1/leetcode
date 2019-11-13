package simple;

/**
 * @ClassName Merge
 * @Description TODO
 * @Author leis
 * @Date 2019/11/13 18:15
 * @Version 1.0
 **/
public class Merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] elem = new int[m];
        System.arraycopy(nums1, 0, elem, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < m && p2 < n) {
            nums1[p++] = elem[p1] < nums2[p2] ? elem[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(elem, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + "\t");
        }
    }
}
