package nowcoder.alg;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BM12 {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode sortInList(ListNode head) {
        // write code here
        if (head.next == null) {
            return head;
        }
        ListNode p = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        p = new ListNode(-1);
        head = p;
        for (int i = 0; i < res.length; i++) {
            p.next = new ListNode(res[i]);
            p = p.next;
        }
        return head.next;


    }

    public static ListNode sortInList1(ListNode head) {
        ArrayList<Integer> nums = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            nums.add(p.val);
            p = p.next;
        }
        p = head;
        Collections.sort(nums);
        for (int i = 0; i < nums.size(); i++) {
            p.val = nums.get(i);
            p = p.next;
        }
        return head;
    }

    //todo 归并
    public static ListNode sortInList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        while (right != null && right.next != null) {
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }
        left.next = null;
        return merge(sortInList2(head), sortInList2(mid));
    }

    public static ListNode merge(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val < pHead2.val) {
                cur.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                cur.next = pHead2;
                pHead2 = pHead2.next;
            }
            cur = cur.next;
        }

        if (pHead1 != null) {
            cur.next = pHead1;
        } else {
            cur.next = pHead2;
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(2);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        ListNode listNode = sortInList(h1);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }

    }
}
