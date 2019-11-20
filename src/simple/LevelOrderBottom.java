package simple;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LevelOrderBottom
 * @Description 二叉数层次遍历
 * @Author leis
 * @Date 2019/11/18 17:45
 * @Version 1.0
 **/
public class LevelOrderBottom {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            ((LinkedList<List<Integer>>) result).addFirst(list);
        }
        return result;
    }


}
