package toO;

import java.util.LinkedList;
import java.util.Queue;

public class t28 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;
        return recur(root.left, root.right);
    }

    public static boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
    }


    public static boolean isSymmetric1(TreeNode root) {
        if (root == null)
            return false;
        if (root.left == null || root.right == null) {
            return false;
        }
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        left.add(root.left);
        right.add(root.right);
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode l = left.poll();
            TreeNode r = right.poll();
            if (l == null && r == null) {
                continue;
            }
            if (l == null || r == null || l.val != r.val) {
                return false;
            }
            left.add(l.left);
            left.add(l.right);
            right.add(r.right);
            right.add(r.left);
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(3);
        treeNode.left = t1;
        treeNode.right = t2;
        t1.right = t3;
        t2.right = t6;
        System.out.println(isSymmetric1(treeNode));
    }
}
