package toO;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class t59_2 {

    Queue<Integer> q;
    Deque<Integer> d;


    public t59_2() {
        q = new LinkedList<>();
        d = new LinkedList<>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println(list.getFirst());
    }
}
