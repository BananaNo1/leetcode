package simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class s257 {

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

    // 深度
    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return null;
        List<String> res = new LinkedList<>();
        String s = "";
        findPath(root, res, s + root.val);
        return res;
    }

    public static void findPath(TreeNode root, List<String> res, String s) {
        if (root.left == null && root.right == null) {
            res.add(s);
            return;
        }
        if (root.left != null) {
            findPath(root.left, res, s + "->" + root.left.val);

        }
        if (root.right != null) {
            findPath(root.right, res, s + "->" + root.right.val);
        }
    }

    public static List<String> binaryTreePaths1(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    public static void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(root.val);
            if (root.left == null && root.right == null) {
                paths.add(pathSB.toString());
            } else {
                pathSB.append("->");
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }


    //广度
//    public staitc void

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(5);
        root.left = r1;
        root.right = r2;
        r2.right = r3;
        List<String> strings = binaryTreePaths(root);
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }
}
