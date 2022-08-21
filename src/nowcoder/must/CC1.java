package nowcoder.must;

import java.util.LinkedList;
import java.util.Queue;

public class CC1 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 注意只有一个子节点情况
     * dfs
     *
     * @param root
     * @return
     */
    public static int run(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null || root.right == null) {
            return Math.max(run(root.left), run(root.right)) + 1;
        }
        return Math.min(run(root.left), run(root.right)) + 1;
    }

    /**
     * bfs
     * 注意队列 size属性
     *
     * @param root
     * @return
     */
    public static int run1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deep = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();
            //todo 把size写循环中 还是queue.size()写循环中
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return deep;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            deep++;
        }
        return deep;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(5);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r1.right = r4;
        System.out.println(run1(root));
    }

}
