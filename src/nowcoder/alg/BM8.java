package nowcoder.alg;

public class BM8 {


    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        if (pHead == null) {
            return null;
        }
        ListNode res = pHead;
        ListNode fast = pHead;
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while (fast != null) {
            res = res.next;
            fast = fast.next;
        }
        return res;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode res = FindKthToTail(l1, 2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
