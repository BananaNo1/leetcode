package nowcoder.alg;

public class BM6 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        ListNode r1 = new ListNode(4);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(3);
        root.next = r1;
        r1.next = r2;
        r2.next = root;
        r3.next = root;
        System.out.println(hasCycle(root));
    }

}
