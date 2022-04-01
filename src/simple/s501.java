package simple;

import java.util.ArrayList;
import java.util.List;

public class s501 {

    public class TreeNode {
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

    List<Integer> answer = new ArrayList<>();
    int base, maxCount, count;

    public int[] findMode1(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    public void update(int x) {
        if (x == base) {
            count++;
        } else {
            count = 1;
            base = x;
        }

        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

    /**
     *
     *  1.如果cur无左孩子，cur向右移动（cur=cur.right）
     *  2.如果cur有左孩子，找到cur左子树上最右的节点，记为mostright
     *      1.如果mostright的right指针指向空，让其指向cur，cur向左移动（cur=cur.left）
     *      2.如果mostright的right指针指向cur，让其指向空，cur向右移动（cur=cur.right）
     *
     *
     * @param root
     * @return
     */
    //todo
    public int[] findMode2(TreeNode root) {
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            mode[i] = answer.get(i);
        }
        return mode;
    }


    public static void main(String[] args) {

    }
}
