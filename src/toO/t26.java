package toO;

public class t26 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public static boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        TreeNode A_left = new TreeNode(4);
        TreeNode A_right = new TreeNode(1);
        TreeNode A_left_left = new TreeNode(1);
        TreeNode A_left_right = new TreeNode(2);
        A.left = A_left;
        A.right = A_right;
        A_left.left = A_left_left;
        A_left.right = A_left_right;

        TreeNode B = new TreeNode(4);
        TreeNode B_left = new TreeNode(1);
        B.left = B_left;

        System.out.println(isSubStructure(A, B));

    }
}
