package simple;

public class s482 {

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String result = "";
        String[] strs = s.split("-");
        for (String str : strs) {
            result += str;
        }
        result = result.toUpperCase();
        if (result.length() <= k) {
            return result;
        }
        int l1 = result.length() % k;
        int num = result.length() / k;
        if (l1 != 0) {
            sb.append(result.substring(0, l1)).append("-");
            result = result.substring(l1);
        }
        while (num > 1) {
            sb.append(result.substring(0, k)).append("-");
            result = result.substring(k);
            num--;
        }
        return sb.append(result).toString();
    }

    public static String licenseKeyFormatting1(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                cnt++;
                ans.append(Character.toUpperCase(s.charAt(i)));
                if (cnt % k == 0) {
                    ans.append("-");
                }
            }
        }
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.reverse().toString();
    }


    public static void main(String[] args) {
        String s = "2";
        int k = 2;
        System.out.println(licenseKeyFormatting1(s, k));
    }
}
