package nowcoder.alg;

import java.util.LinkedList;
import java.util.Queue;

public class BM31 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return is(pRoot.left, pRoot.right);
    }

    public static boolean is(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return true;
        }
        return is(left.left, right.right) && is(left.right, right.left);
    }

    boolean recursion(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return recursion(root1.left, root2.right) && recursion(root1.right, root2.left);
    }

    //todo
    boolean isSymmetrical1(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(pRoot.left);
        q2.offer(pRoot.right);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode left = q1.poll();
            TreeNode right = q2.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            q1.offer(left.left);
            q1.offer(left.right);

            q2.offer(right.right);
            q2.offer(right.left);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
