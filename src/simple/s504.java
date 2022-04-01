package simple;

public class s504 {

    public String convertToBase7_1(int num) {
        return Integer.toString(num, 7);
    }

    public static String convertToBase7_2(int num) {
        StringBuffer sb = new StringBuffer();
        int temp = num;
        int nums = Math.abs(num);
        while (nums >= 7) {
            int n = nums % 7;
            sb.append(n);
            nums = nums / 7;
        }
        sb.append(nums);
        if (temp < 0) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7_2(100));
    }
}
