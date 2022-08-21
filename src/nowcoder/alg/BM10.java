package nowcoder.alg;

import java.util.HashMap;
import java.util.HashSet;

public class BM10 {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int l1 = 0;
        int l2 = 0;
        ListNode count = pHead1;
        ListNode slow = null;
        ListNode fast = null;
        while (count != null) {
            l1++;
            count = count.next;
        }
        count = pHead2;
        while (count != null) {
            l2++;
            count = count.next;
        }
        if (l1 > l2) {
            fast = pHead1;
            slow = pHead2;
        } else {
            fast = pHead2;
            slow = pHead1;
        }
        int k = Math.abs(l1 - l2);
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null && slow != null) {
            if (fast == slow) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return null;
    }

    public static ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

    public static ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();

        while (pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            if (set.contains(pHead2))
                return pHead2;
            pHead2 = pHead2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l6;
        l6.next = l7;
        l4.next = l5;
        l5.next = l6;
        ListNode res = FindFirstCommonNode(l1, l4);
        System.out.println(res.val);
    }
}
