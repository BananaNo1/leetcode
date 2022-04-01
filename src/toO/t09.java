package toO;

import java.util.Stack;

public class t09 {

    Stack<Integer> stack1, stack2;

    public t09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return stack1.pop();
    }

    public static void main(String[] args) {
        t09 t = new t09();
        int param1 = t.deleteHead();
        t.appendTail(5);
        t.appendTail(2);
        int param2 = t.deleteHead();
        int param3 = t.deleteHead();
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(param3);
    }
}
