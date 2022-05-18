package toO;

import java.util.Arrays;
import java.util.PriorityQueue;

public class t40 {


    /**
     * 大根堆
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    /**
     * 数组排序
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers1(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 排序
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers2(int[] arr, int k) {
        quickSort2(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);
        return Arrays.copyOf(arr, k);
    }

    private static void quickSort2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        quickSort2(arr, l, i - 1);
        quickSort2(arr, i + 1, r);
    }

    /**
     * 基于快速排序的数组划分
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers3(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        return quickSort3(arr, k, 0, arr.length - 1);
    }

    private static int[] quickSort3(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) {
            return quickSort3(arr, k, l, i - 1);
        }
        if (i < k) {
            return quickSort3(arr, k, i + 1, r);
        }
        return Arrays.copyOf(arr, k);
    }


    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        int[] res = getLeastNumbers2(arr, k);
        System.out.println();
        Arrays.stream(res).forEach(System.out::print);

    }

}
