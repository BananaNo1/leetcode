package simple;

import java.util.LinkedList;
import java.util.Queue;

public class s404 {

    public class TreeNode {
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


    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null) {
                if (temp.left.left == null && temp.left.right == null) {
                    sum = sum + temp.left.val;
                } else {
                    queue.offer(temp.left);
                }
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return sum;
    }


    public int sumOfLeftLeaves1(TreeNode root) {
        return root == null ? dfs(root) : 0;
    }

    public int dfs(TreeNode node) {
        int sum = 0;
        if (node.left != null) {
            sum += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            sum += dfs(node.right);
        }
        return sum;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {

    }
}
