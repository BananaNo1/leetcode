package simple;

import java.util.LinkedList;

/**
 * @ClassName IsSameTree
 * @Description 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @Author leis
 * @Date 2019/11/14 16:50
 * @Version 1.0
 **/
public class IsSameTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (q == null || p == null) {
            return false;
        }
        if (q.val != p.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    //队列
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (!check(p, q)) {
            return false;
        }
        LinkedList<TreeNode> pQ = new LinkedList<>();
        LinkedList<TreeNode> qQ = new LinkedList<>();

        pQ.addFirst(p);
        qQ.addFirst(q);

        while (!pQ.isEmpty()) {
            p = pQ.removeFirst();
            q = qQ.removeFirst();

            if (!check(p, q)) {
                return false;
            }

            if (p != null) {
                if (!check(p.left, q.left)) {
                    return false;
                }
                if (p.left != null) {
                    pQ.addLast(p.left);
                    qQ.addLast(q.left);
                }
                if (p.right != null) {
                    pQ.addLast(p.right);
                    qQ.addLast(q.right);
                }
            }
        }
        return true;
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (q == null || p == null) {
            return false;
        }
        if (q.val != p.val) {
            return false;
        }
        return true;
    }

}
