package nowcoder.alg;

import java.util.ArrayList;
import java.util.Stack;

public class BM13 {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean isPail(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            sb = sb.append(p.val);
            stack.push(p.val);
            p = p.next;
        }
        while (!stack.isEmpty()) {
            sb2.append(stack.pop());
        }
        if (sb.toString().equals(sb2.toString())) {
            return true;
        }
        return false;
    }

    //反转
    public static boolean isPail1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
            mid = mid.next;
        }
        left.next = null;

//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast!=null && fast.next!=null){
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        slow 在中点处


        ListNode q = reverseList(mid);
        while (head != null && q != null) {
            if (head.val != q.val) {
                return false;
            }
            head = head.next;
            q = q.next;
        }
        if (head != null && q != null) {
            return false;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = null;
        while (p != null) {
            ListNode next = p.next;
            p.next = q;
            q = p;
            p = next;
        }
        return q;
    }

    public static boolean isPail2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int x = list.get(left);
            int y = list.get(right);
            if (x != y) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(2);
        ListNode r4 = new ListNode(1);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        System.out.println(isPail1(r1));
    }
}
