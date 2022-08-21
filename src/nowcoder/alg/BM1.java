package nowcoder.alg;

import java.util.Stack;

/**
 * 反转链表
 */
public class BM1 {


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 增加头结点
     *
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = root.next;
            root.next = head;
            head = next;
        }
        return root.next;
    }

    public static ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head, r;
        ListNode q = null;
        while (p != null) {
            r = p.next;
            p.next = q;
            q = p;
            p = r;
        }
        return q;
    }

    /**
     * 可使用栈
     * 注意链表成环
     * @param head
     */
    public static ListNode ReverseList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode root = stack.pop();
        head = root;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            root.next = node;
            root = root.next;
        }
        root.next = null;
        return head;
    }


    public static void main(String[] args) {
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(3);
        ListNode r4 = new ListNode(4);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        ListNode head = ReverseList2(r1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
