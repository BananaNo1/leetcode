package nowcoder;

import java.util.PriorityQueue;
import java.util.Scanner;

public class beiyou2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }
        int ans = 0;
        while (q.size() > 1) {
            int first = q.poll();
            int sec = q.poll();
            ans += (first + sec);
            q.add(first + sec);
        }
        System.out.println(ans);
    }

}
