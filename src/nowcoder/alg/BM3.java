package nowcoder.alg;

public class BM3 {


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        if (k <= 1 || head == null) {
            return head;
        }
        int len = 0;
        ListNode pre = head;
        while (pre != null) {
            pre = pre.next;
            len++;
        }
        if (len < k) {
            return head;
        }
        int count = len / k;
        pre = new ListNode(0);
        ListNode now = pre;
        for (int i = 0; i < count; i++) {
            ListNode tmp = null;
            for (int j = 0; j < k; j++) {
                ListNode b = head.next;
                head.next = tmp;
                tmp = head;
                head = b;
            }
            now.next = tmp;
            while (now.next != null) {
                now = now.next;
            }
        }
        now.next = head;
        return pre.next;
    }



    public static void main(String[] args) {

    }


}
