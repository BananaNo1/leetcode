package nowcoder.alg;

public class BM4 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
//                ListNode tmp =  new ListNode(list1.val);
//                head.next = tmp;
                head.next = list1;
                list1 = list1.next;
            } else {
//                ListNode tmp =  new ListNode(list2.val);
//                head.next = tmp;
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list1_2 = new ListNode(3);
        ListNode list1_3 = new ListNode(5);
        list1.next = list1_2;
        list1_2.next = list1_3;


        ListNode list2 = new ListNode(2);
        ListNode list2_2 = new ListNode(4);
        ListNode list2_3 = new ListNode(6);
        list2.next = list2_2;
        list2_2.next = list2_3;

        ListNode res = Merge(list1, list2);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
}
