package simple;

import java.util.ArrayList;
import java.util.List;

public class s235 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();
        TreeNode node = root;
        while (node.val != p.val) {
            listP.add(node);
            if (node.val > p.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        listP.add(p);
        node = root;
        while (node.val != q.val) {
            listQ.add(node);
            if (node.val > q.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        listQ.add(q);
        for (int i = listP.size() - 1; i >= 0; i--) {
            if (listQ.contains(listP.get(i))) {
                return listP.get(i);
            }
        }
        return null;
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(8);
        TreeNode r3 = new TreeNode(0);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(7);
        TreeNode r6 = new TreeNode(9);
        TreeNode r7 = new TreeNode(3);
        TreeNode r8 = new TreeNode(5);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r1.right = r4;
        r2.left = r5;
        r2.right = r6;
        r3.left = null;
        r3.right = null;
        r4.left = r7;
        r4.right = r8;
        TreeNode res = lowestCommonAncestor(root, r1, r4);
        System.out.println(res.val);
    }
}
