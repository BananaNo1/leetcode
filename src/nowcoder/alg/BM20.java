package nowcoder.alg;

public class BM20 {

    public static int mod = 1000000007;

    public static int InversePairs(int[] array) {
        int n = array.length;
        int[] res = new int[n];
        return mergeSort(0, n - 1, array, res);
    }

    public static int mergeSort(int left, int right, int[] data, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int res = mergeSort(left, mid, data, temp) + mergeSort(mid + 1, right, data, temp);
        res = res % mod;

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            temp[k] = data[k];
        }
        // 排序
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                data[k] = temp[j++];
            } else if (j == right + 1 || temp[i] <= temp[j]) {
                data[k] = temp[i++];
            } else {
                data[k] = temp[j++];
                res += mid - i + 1;
            }
        }
        return res % mod;

    }

    private static int cnt;

    public static int InversePairs1(int[] array) {
        MergeSort1(array, 0, array.length - 1);
        return cnt;
    }

    public static void MergeSort1(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        MergeSort1(array, left, mid);
        MergeSort1(array, mid + 1, right);
        MergeOne(array, left, mid, right);
    }

    public static void MergeOne(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int k = 0, i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                cnt = (cnt + mid - i + 1) % mod;
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= end) {
            temp[k++] = array[j++];
        }
        for (int l = 0; l < k; l++) {
            array[start + l] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(arr));
    }
}
