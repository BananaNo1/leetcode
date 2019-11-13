package simple;

/**
 * @ClassName DeleteDuplicates
 * @Description 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @Author leis
 * @Date 2019/11/13 17:42
 * @Version 1.0
 **/
public class DeleteDuplicates {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
