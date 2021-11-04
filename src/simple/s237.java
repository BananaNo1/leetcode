package simple;

/**
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
 */
public class s237 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(4);
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(9);
        list.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        deleteNode(l1);
        while (list != null) {
            System.out.print(list.val + "->");
            list = list.next;
        }
        System.out.println();
    }

}
