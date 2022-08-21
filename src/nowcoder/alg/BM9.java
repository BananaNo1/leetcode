package nowcoder.alg;

public class BM9 {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n + 1; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return head.next;
            }
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode res = removeNthFromEnd(l1, 1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
