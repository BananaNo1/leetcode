package nowcoder.alg;

import java.util.*;

public class BM23 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int[] preorderTraversal(TreeNode root) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    public void preOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        if (root.left != null) {
            preOrder(root.left, list);
        }
        if (root.right != null) {
            preOrder(root.right, list);
        }
    }

    /**
     * 不递归 使用栈
     *
     * @param root
     * @return
     */
    public static int[] preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root == null) {
            return new int[0];
        }
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            list.add(node.val);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
