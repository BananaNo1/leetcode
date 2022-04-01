package simple;

public class s415 {

    public static String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int add = 0;
        StringBuffer sb = new StringBuffer();
        while (l1 > 0 || l2 > 0 || add != 0) {
            int x = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int y = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            int result = x + y + add;
            sb.append(result % 10);
            add = result / 10;
            l1--;
            l2--;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";
        System.out.println(addStrings(num1, num2));
    }
}
