package simple;

/**
 * @ClassName MergeTwoLists
 * @Description 合并两个有序链表
 * @Author leis
 * @Date 2019/7/12 16:09
 * @Version 1.0
 **/
public class MergeTwoLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l1 = l1.next;
            } else {
                cur.next = l1;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
//        while (l1.next != null) {
//            cur.next = l1;
//            cur = cur.next;
//            l1 = l1.next;
//
//        }
//        while (l2.next != null) {
//            cur.next = l2;
//            cur = cur.next;
//            l2 = l2.next;
//        }
        return head.next;
    }
}
