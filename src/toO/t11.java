package toO;

public class t11 {


    public static int minArray(int[] numbers) {
        int i = 0;
        while (i < numbers.length - 1 && numbers[i] <= numbers[i + 1])
            i++;
        if (i == numbers.length - 1) {
            return numbers[0];
        }
        return numbers[i + 1];
    }

    public static int minArray1(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return numbers[i];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(minArray(arr));
    }
}
