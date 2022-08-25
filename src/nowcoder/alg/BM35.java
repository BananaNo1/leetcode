package nowcoder.alg;

import java.util.LinkedList;
import java.util.Queue;

public class BM35 {


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public boolean isCompleteTree(TreeNode root) {
        // write code here
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        boolean notComplete = false;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur == null) {
                notComplete = true;
                continue;
            }
            if (notComplete) {
                return false;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
