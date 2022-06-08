import java.util.Arrays;

public class quickSort {

    public static int[] sort(int[] arr) {
        if (arr.length <= 1) {
            return null;
        }
        quick(arr, 0, arr.length - 1);
        return arr;
    }

    public static void quick(int[] arr, int l, int r) {
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
        quick(arr, l, i - 1);
        quick(arr, i + 1, r);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        int[] res = sort(arr);
        Arrays.stream(res).forEach(System.out::print);
    }
}
