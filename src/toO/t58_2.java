package toO;

public class t58_2 {

    public static String reverseLeftWords(String s, int n) {
        if (n == s.length()) {
            return s;
        }
        String left = s.substring(0, n);
        String right = s.substring(n);
        return right + left;
    }

    public static String reverseLeftWords1(String s, int n) {
        String res = "";
        for (int i = n; i < n + s.length(); i++) {
            res += s.charAt(i % s.length());
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "lrloseumgh";
        System.out.println(reverseLeftWords1(s, 6));
    }
}
