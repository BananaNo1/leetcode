package medium;

public class m98 {

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


    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val < pre) {
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }
}
