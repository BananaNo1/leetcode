package nowcoder.alg;

public class BM34 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int pre = Integer.MIN_VALUE;

    public static boolean isValidBST(TreeNode root) {
        // write code here
        if (root == null) {
            return true;
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


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.println(isValidBST(t1));
    }
}
