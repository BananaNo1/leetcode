package toO;


import java.util.Stack;

public class t06 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int length = stack.size();
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = stack.pop().val;
        }
        return ans;
    }


    public static void main(String[] args) {

    }

}
