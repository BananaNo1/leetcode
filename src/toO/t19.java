package toO;


//todo
public class t19 {

    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            char sc = s.charAt(i);
            char pc = p.charAt(j);
            if (sc == pc) {
                i++;
                j++;
            } else if (pc == '.') {
                i++;
                j++;
            } else {
                if (pc == '*' && (sc == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                    i++;
                } else if (p.charAt(j + 1) == '*') {
                    j = j + 2;
                } else {
                    return false;
                }
            }
        }
        if (i == n) {
            return true;
        }
        return false;
    }
    //todo
    public static boolean isMatch1(String s, String p) {
        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int j = 2; j < n; j += 2)
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = p.charAt(j - 1) == '*' ?
                        dp[i][j - 2] || dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') :
                        dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "ab*.*";
        System.out.println(isMatch(s, p));
    }
}
