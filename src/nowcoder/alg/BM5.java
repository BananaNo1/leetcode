package nowcoder.alg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BM5 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // todo timeout
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null) {
            return null;
        }
        if (lists.size() <= 1) {
            return lists.get(0);
        }

        int size = lists.size();
        ListNode res = lists.get(0);
        int i = 1;
        while (i < size) {
            res = mergeTwo(res, lists.get(i));
            i++;
        }
        return res;
    }

    public static ListNode mergeTwo(ListNode list1, ListNode list2) {
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
                head.next = list1;
                list1 = list1.next;
            } else {
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


    public static ListNode mergeKLists1(ArrayList<ListNode> lists) {
        return merge(lists, 0, lists.size() - 1);
    }

    public static ListNode merge(ArrayList<ListNode> lists, int l, int r) {
        if (l == r) {
            return lists.get(l);
        }
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        return mergeTwo(merge(lists, l, mid), merge(lists, mid + 1, r));
    }


    public static ListNode mergeKLists2(ArrayList<ListNode> lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
        }
        return dummyHead.next;
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


        ListNode list3 = new ListNode(1);
        ListNode list3_2 = new ListNode(3);
        ListNode list3_3 = new ListNode(5);
        list3.next = list3_2;
        list3_2.next = list3_3;

        ArrayList<ListNode> listNodes = new ArrayList<>();
        listNodes.add(list1);
        listNodes.add(list2);
        listNodes.add(list3);

        ListNode res = mergeKLists(listNodes);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println();

    }
}
