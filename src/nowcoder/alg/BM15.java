package nowcoder.alg;

import java.util.HashMap;

public class BM15 {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(pre.val, 1);
        while (cur != null) {
            if (map.containsKey(cur.val)) {
                pre.next = cur.next;
                cur.next = null;
            } else {
                pre = pre.next;
                map.put(cur.val, 1);
            }
            cur = pre.next;
        }
        return head;
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(1);
        ListNode r3 = new ListNode(1);
        ListNode r4 = new ListNode(1);
        ListNode r5 = new ListNode(1);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
        ListNode p = deleteDuplicates(r1);
        while (p != null) {
            System.out.printf(p.val + " ");
            p = p.next;
        }

    }
}
