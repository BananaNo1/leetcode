package simple;

public class s434 {

    public static int countSegments(String s) {
        if (s.length() == 0)
            return 0;
        String[] arr = s.split(" ");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!"".equals(arr[i])) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = ", , , ,        a, eaefa";

        System.out.println(countSegments(s));
    }
}
