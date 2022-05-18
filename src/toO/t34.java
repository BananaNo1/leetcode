package toO;

import java.util.LinkedList;
import java.util.List;

public class t34 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static List<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    public static void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode r1 = new TreeNode(4);
        TreeNode r2 = new TreeNode(8);
        TreeNode r3 = new TreeNode(11);
        TreeNode r4 = new TreeNode(13);
        TreeNode r5 = new TreeNode(4);
        TreeNode r6 = new TreeNode(7);
        TreeNode r7 = new TreeNode(2);
        TreeNode r8 = new TreeNode(5);
        TreeNode r9 = new TreeNode(1);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;
        r5.left = r8;
        r5.right = r9;
        List<List<Integer>> lists = pathSum(root, 22);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }
}
