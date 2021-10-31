package simple;

public class s203 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
//        ListNode pre = new ListNode(val - 1);
//        pre.next = head;
//        ListNode root = pre;
//        while (root != null) {
//            if (root.val == val) {
//                pre.next = root.next;
//                root = pre.next;
//            } else {
//                pre = root;
//                root = root.next;
//            }
//        }
//        return pre.next;


        ListNode root = new ListNode(val - 1);
        root.next = head;
        ListNode pre = root;

        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(7);
        ListNode l4 = new ListNode(7);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;
        removeElements(head, 7);
    }
}
