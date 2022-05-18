package toO;

import java.util.Stack;

public class t27 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode mirrorTree(TreeNode root) {
        exchange(root);
        return root;
    }

    public static void exchange(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            exchange(root.left);
        }
        if (root.right != null) {
            exchange(root.right);
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public static TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(9);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;

        mirrorTree(root);

    }


}
