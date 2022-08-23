package nowcoder.alg;

import java.util.*;

public class BM27 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null) {
            return res;
        }
        queue.add(pRoot);
        int num = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (num % 2 != 0) {
                    list.add(temp.val);
                } else {
                    stack.add(temp.val);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            num++;
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            res.add(list);
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null) {
            return res;
        }
        queue.offer(pRoot);
        TreeNode temp;
        boolean flag = true;
        while (!queue.isEmpty()) {
            ArrayList<Integer> row = new ArrayList<>();
            int n = queue.size();
            flag = !flag;
            for (int i = 0; i < n; i++) {
                temp=queue.poll();
                row.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            if(flag){
                Collections.reverse(row);
            }
            res.add(row);
        }
        return res;
    }


}
