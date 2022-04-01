package nowcoder.toOffer;

public class JZ5 {

    public static String replaceSpace(String s) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = " ";
        System.out.println(replaceSpace(s));
    }
}
