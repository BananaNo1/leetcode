package nowcoder.toOffer;

import java.util.ArrayList;
import java.util.Stack;

public class JZ6 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        ListNode temp;
        if (listNode == null) {
            return new ArrayList<>();
        }
        ListNode newHead = new ListNode(0);
        while (listNode != null) {
            temp = listNode;
            listNode = listNode.next;
            temp.next = newHead.next;
            newHead.next = temp;
        }
        while (newHead.next != null) {
            ans.add(newHead.next.val);
            newHead = newHead.next;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
