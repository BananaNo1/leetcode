package simple;

/**
 * @ClassName MaxDepth
 * @Description TODO
 * @Author leis
 * @Date 2019/11/15 17:31
 * @Version 1.0
 **/
public class MaxDepth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return depth(root.left, root.right, 1);
    }

    public int depth(TreeNode left, TreeNode right, int max) {
        if (left == null && right == null) {
            return max;
        }
        if (left == null) {
            return depth(right.left, right.right, max + 1);
        }
        if (right == null) {
            return depth(left.left, left.right, max + 1);
        }
        return Math.max(depth(left.left, left.right, max + 1), depth(right.left, right.right, max + 1));
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth2(root.left);
            int right = maxDepth2(root.right);
            return Math.max(left, right) + 1;
        }
    }


}
