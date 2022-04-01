package nowcoder.toOffer;

public class JZ3 {

    public static int duplicate(int[] numbers) {
        int[] arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[numbers[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(duplicate(numbers));
    }
}
