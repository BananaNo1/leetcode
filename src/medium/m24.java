package medium;


public class m24 {

    public class ListNode {
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

    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode();
        root.next = head;
        head = root;
        while (head != null && head.next != null && head.next.next != null) {
            ListNode p = head.next;
            head.next = head.next.next;
            p.next = p.next.next;
            head.next.next = p;
        }
        return root.next;
    }

    // 递归
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {

    }
}
