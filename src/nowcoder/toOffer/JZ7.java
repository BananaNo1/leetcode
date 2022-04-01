package nowcoder.toOffer;

public class JZ7 {
    /**
     * 前序 中序
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (pre == null || pre.length <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        build(root, pre, 0, pre.length, vin, 0, vin.length);
        return root;
    }

    public static void build(TreeNode root, int[] pre, int pleft, int pright, int[] vin, int vleft, int vright) {
        int i = 0;
        for (i = vleft; i < vright; i++) {
            if (vin[i] == root.val) {
                break;
            }
        }
        int t = i - vleft;
        if (t > 0) {
            root.left = new TreeNode(pre[pleft + 1]);
            build(root.left, pre, pleft + 1, pleft + 1 + t, vin, vleft, i);
        }
        if (pright - pleft - 1 - t > 0) {
            root.right = new TreeNode(pre[pleft + 1 + t]);
            build(root.right, pre, pleft + 1 + t, pright, vin, i + 1, vright);
        }
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] vin = {4, 7, 2, 1, 5, 3, 8, 6};
        reConstructBinaryTree(pre, vin);
    }
}
