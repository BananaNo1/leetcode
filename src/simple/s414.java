package simple;

import java.util.TreeSet;

public class s414 {

    public static int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() == 3 ? set.first() : set.last();
    }

    public static int thirdMax1(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) b;
    }


    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        System.out.println(thirdMax1(nums));
    }
}
