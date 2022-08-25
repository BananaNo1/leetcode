package nowcoder.alg;

import java.util.Stack;

public class BM30 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode head = null;
    public TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.left);
        if (pre == null) {
            head = pRootOfTree;
            pre = pRootOfTree;
        } else {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return head;
    }

    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode head = null;
        TreeNode pre = null;
        boolean isFirst = true;
        while (pRootOfTree != null || !s.isEmpty()) {
            while (pRootOfTree != null) {
                s.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }
            pRootOfTree = s.pop();
            if (isFirst) {
                head = pRootOfTree;
                pre = head;
                isFirst = false;
            } else {
                pre.right = pRootOfTree;
                pRootOfTree.left = pre;
                pre = pRootOfTree;
            }
            pRootOfTree = pRootOfTree.right;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
