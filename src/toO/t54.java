package toO;

import java.util.ArrayList;
import java.util.List;

public class t54 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static List<Integer> list = new ArrayList<>();

    public static int kthLargest(TreeNode root, int k) {
        order(root);
        return list.get(k - 1);
    }

    public static void order(TreeNode root) {
        if (root == null) {
            return;
        }
        order(root.right);
        list.add(root.val);
        order(root.left);
    }

    int res, k;

    public int kthLargest1(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(4);
        TreeNode r4 = new TreeNode(2);
        root.left = r1;
        root.right = r2;
        r1.right = r4;
        System.out.println(kthLargest(root, 1));

    }
}
