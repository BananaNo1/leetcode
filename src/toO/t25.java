package toO;

public class t25 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root = new ListNode(0);
        ListNode tmp = root;
        while (l1 != null && l2 != null) {
            ListNode t;
            if (l1.val > l2.val) {
                t = new ListNode(l2.val);
                tmp.next = t;
                l2 = l2.next;
            } else {
                t = new ListNode(l1.val);
                tmp.next = t;
                l1 = l1.next;
            }
            tmp = t;
        }
        if (l1 != null) {
            tmp.next = l1;
        }
        if (l2 != null) {
            tmp.next = l2;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;
        l2.next = l22;
        l22.next = l23;
        mergeTwoLists(l1, l2);
    }
}
