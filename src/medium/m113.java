package medium;

import java.util.*;

public class m113 {


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

    static List<List<Integer>> res = new ArrayList<>();

    // method1
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return null;
        }
        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    public static void dfs(TreeNode node, int targetSum, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.val == targetSum && node.left == null && node.right == null) {
            res.add(new ArrayList<>(list));
        }
        dfs(node.left, targetSum - node.val, list);
        dfs(node.right, targetSum - node.val, list);
        list.remove(list.size() - 1);
    }

    //method2
    static Map<TreeNode, TreeNode> map = new HashMap<>();

    public static List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;
            if (node.left == null && node.right == null) {
                if (rec == targetSum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }
        return res;
    }

    public static void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        res.add(new LinkedList<>(temp));
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
        List<List<Integer>> lists = pathSum1(root, 22);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
