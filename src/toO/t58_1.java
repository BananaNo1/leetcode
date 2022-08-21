package toO;

public class t58_1 {

    public static String reverseWords(String s) {
        s = s.trim();
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (!"".equals(strs[i])) {
                sb.append(strs[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static String reverseWords1(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            res.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return res.toString().trim();
    }


    public static void main(String[] args) {
        String res = "a good   example";
        System.out.println(reverseWords1(res));
    }
}
