package medium;

public class m96 {

    public static int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        int[] G = new int[n + 1];
        //G(n)  长度为 n 的序列能构成的不同二叉搜索树的个数。
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }


    public static void main(String[] args) {
        System.out.println(numTrees(2));
    }
}
