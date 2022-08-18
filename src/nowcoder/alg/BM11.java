package nowcoder.alg;

import simple.Reverse;

public class BM11 {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // int long 越界
    public static ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
//        String h1 = "";
//        String h2 = "";
        while (head1 != null) {
//            h1 = h1 + head1.val;
            s1.append(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
//            h2 = h2 + head2.val;
            s2.append(head2.val);
            head2 = head2.next;
        }


        ListNode head = new ListNode(0);
        s1 = s1.reverse();
        s2 = s2.reverse();
//        int r1 = Integer.parseInt(h1);
//        int r2 = Integer.parseInt(h2);
//        int res = r1 + r2;
//        while (res != 0) {
//            int v = res % 10;
//            ListNode p = new ListNode(v);
//            p.next = head.next;
//            head.next = p;
//            res = res / 10;
//        }
        int length = Math.min(s1.length(), s2.length());
        int count = 0;
        for (int i = 0; i < length; i++) {
            int a = s1.charAt(i) - '0';
            int b = s2.charAt(i) - '0';
            int res = a + b + count;
            int v = res % 10;
            count = res / 10;
            ListNode p = new ListNode(v);
            p.next = head.next;
            head.next = p;
        }
        String h1 = s1.substring(length, s1.length());
        String h2 = s2.substring(length, s2.length());
        String remain = h1.length() == 0 ? h2 : h1;
        for (int i = 0; i < remain.length(); i++) {
            int a = remain.charAt(i) - '0';
            int res = a + count;
            int v = res % 10;
            count = res / 10;
            ListNode p = new ListNode(v);
            p.next = head.next;
            head.next = p;
        }
        if (count == 1) {
            ListNode p = new ListNode(1);
            p.next = head.next;
            head.next = p;
        }
        return head.next;
    }

    // 反转链表 + 计算
    public static ListNode addInList1(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        head1 = ReverseList(head1);
        head2 = ReverseList(head2);
        ListNode res = new ListNode(-1);
        ListNode head = res;
        int carry = 0;
        while (head1 != null || head2 != null || carry != 0) {
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;

            int temp = val1 + val2 + carry;

            carry = temp / 10;
            temp %= 10;

            head.next = new ListNode(temp);
            head = head.next;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        return ReverseList(res.next);
    }

    public static ListNode ReverseList(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode cur = pHead;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(7);
        ListNode head2 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        head1.next = l2;
        l2.next = l3;
        head2.next = l4;
        ListNode listNode = addInList(head1, head2);
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println();
        StringBuilder sb = new StringBuilder("123");
        System.out.println(sb.substring(3, sb.length()));
    }
}
