package nowcoder.alg;

public class BM36 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right) && Math.abs(depth(root.left) - depth(root.right)) < 2;
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }


    static boolean isBalanced = true;

    public static boolean IsBalanced_Solution1(TreeNode root) {
        TreeDepth(root);
        return isBalanced;
    }

    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = TreeDepth(root.left);
        int r = TreeDepth(root.right);

        if (Math.abs(l - r) > 1) {
            isBalanced = false;
        }

        return Math.max(l, r) + 1;
    }

    //剪枝
    public static int TreeDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = TreeDepth1(root.left);
        if (l == -1) {
            return -1;
        }
        int r = TreeDepth1(root.right);
        if (r == -1) {
            return -1;
        }
        if (Math.abs(l - 1) > 1) {
            isBalanced = false;
            return -1;
        }
        return Math.max(l, r) + 1;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(IsBalanced_Solution(t1));
    }

}
