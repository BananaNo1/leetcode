package nowcoder.alg;

import java.util.ArrayList;

public class BM14 {


    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        if (head.next == null || head.next.next == null) {
            return head;
        }
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        int count = 1;
        while (head != null) {
            if (count % 2 != 0) {
                odd.add(head.val);
            } else {
                even.add(head.val);
            }
            head = head.next;
            count++;
        }
        head = new ListNode(odd.get(0));
        ListNode p = head;
        for (int i = 1; i < odd.size(); i++) {
            ListNode temp = new ListNode(odd.get(i));
            p.next = temp;
            p = p.next;
        }
        for (int i = 0; i < even.size(); i++) {
            ListNode temp = new ListNode(even.get(i));
            p.next = temp;
            p = p.next;
        }
        return head;
    }

    public static ListNode oddEvenList1(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddList = head;
        ListNode evenList = head.next;
        ListNode o = oddList;
        ListNode e = evenList;
        while (o != null && o.next != null && e != null && e.next != null) {
            o.next = o.next.next;
            e.next = e.next.next;
            o = o.next;
            e = e.next;
        }
        if (o == null) {
            o = oddList;
            while (o.next != null) {
                o = o.next;
            }
        }
        o.next = evenList;
        return oddList;
    }

    /**
     * 优化
     * @param head
     * @return
     */
    public static ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode even = head.next;
        ListNode odd = head;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }


    public static void main(String[] args) {
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(3);
        ListNode r4 = new ListNode(4);
        ListNode r5 = new ListNode(5);
        ListNode r6 = new ListNode(6);

        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
//        r5.next = r6;

        ListNode r = oddEvenList1(r1);
        while (r != null) {
            System.out.print(r.val + " ");
            r = r.next;
        }

    }
}
