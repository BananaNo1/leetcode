package toO;

import java.util.HashMap;
import java.util.Map;

public class t07 {
    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap =  new HashMap<Integer, Integer>();
        if (preorder == null || n <= 0) {
            return null;
        }
        if (n == 1) {
            return new TreeNode(preorder[0]);
        }
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode build(int[] preorder, int pl, int pr, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        int pre_root = pl;
        int in_root = indexMap.get(preorder[pre_root]);

        TreeNode root = new TreeNode(preorder[pre_root]);
        int size_left_subtree = in_root - il;
        root.left = build(preorder, pl + 1, pl + size_left_subtree, il, in_root - 1);
        root.right = build(preorder, pl + size_left_subtree+1, pr, in_root + 1, ir);
        return root;
    }

    public static void main(String[] args) {

    }
}
