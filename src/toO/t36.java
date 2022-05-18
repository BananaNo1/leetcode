package toO;

import java.util.LinkedList;

public class t36 {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    //前序遍历
    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> node = new LinkedList<>();
        preOrder(root, node);
        if (node.size() == 1) {
            Node r = node.get(0);
            r.left = r;
            r.right = r;
            return r;
        }

        Node res = node.get(0);
        res.left = node.get(node.size() - 1);
        res.right = node.get(1);
        for (int i = 1; i < node.size() - 1; i++) {
            Node tmp = node.get(i);
            tmp.right = node.get(i + 1);
            tmp.left = node.get(i - 1);
        }
        Node last = node.get(node.size() - 1);
        last.left = node.get(node.size() - 2);
        last.right = node.get(0);
        return res;
    }

    public static void preOrder(Node root, LinkedList<Node> node) {
        if (root == null)
            return;
        preOrder(root.left, node);
        node.add(root);
        preOrder(root.right, node);
    }


    Node pre, head;

    public Node treeToDoublyList1(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        Node r1 = new Node(2);
        Node r2 = new Node(5);
        Node r3 = new Node(1);
        Node r4 = new Node(3);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r1.right = r4;
        Node res = treeToDoublyList(root);
        while (res.right != null) {
            res = res.right;
        }
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.left;
        }
    }
}
