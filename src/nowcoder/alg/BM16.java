package nowcoder.alg;

public class BM16 {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // todo
    public static ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(2);
        ListNode r4 = new ListNode(3);
        ListNode r5 = new ListNode(1);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
//        r4.next = r5;
        ListNode p = deleteDuplicates(r1);
        while (p != null) {
            System.out.printf(p.val + " ");
            p = p.next;
        }
    }
}
