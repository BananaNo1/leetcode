package medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class m114 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static List<TreeNode> list = new LinkedList<>();

    // method1
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root);
        TreeNode cur = root;
        for (int i = 1; i < list.size(); i++) {
            cur.right = list.get(i);
            cur.left = null;
            cur = cur.right;
        }
    }

    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    //method2
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            TreeNode left = curr.left, right = curr.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = curr;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        node.left = node1;
        node.right = node4;
        node1.left = node2;
        node2.right = node3;
        node4.right = node5;
        flatten(node);
    }
}
