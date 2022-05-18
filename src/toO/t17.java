package toO;

public class t17 {

    public static int[] printNumbers(int n) {
        int length = (int) Math.pow(10, n);
        int[] ans = new int[length - 1];
        for (int i = 1; i <= ans.length; i++) {
            ans[i - 1] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = printNumbers(2);
        for (int i = 1; i <= ans.length; i++) {
            System.out.print(ans[i-1] + " ");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

}
