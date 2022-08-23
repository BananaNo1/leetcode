package nowcoder.alg;

import java.util.Stack;

public class BM29 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        // write code here
        if (root == null) {
            return false;
        }
        if (sum == root.val && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.push(root);
        s2.push(root.val);
        while (!s1.isEmpty()) {
            TreeNode temp = s1.pop();
            int cur_sum = s2.pop();
            if (temp.left == null && temp.right == null && cur_sum == sum) {
                return true;
            }
            if (temp.left != null) {
                s1.push(temp.left);
                s2.push(cur_sum + temp.left.val);
            }
            if (temp.right != null) {
                s1.push(temp.right);
                s2.push(cur_sum + temp.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(11);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t5.left = t7;
        t5.right = t8;
        System.out.println(hasPathSum(t1, 22));
    }

}
