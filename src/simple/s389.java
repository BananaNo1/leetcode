package simple;

public class s389 {

    public static char findTheDifference(String s, String t) {
        int[] arrS = new int[26];
        int[] arrT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arrS[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < t.length(); i++) {
            arrT[t.charAt(i) - 97]++;
        }
        for (int i = 0; i < arrS.length; i++) {
            if (arrS[i] != arrT[i])
                return (char) (97 + i);
        }
        return ' ';
    }

    public static char findTheDifference1(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }

    public static char findTheDifference2(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); i++) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    public static char findTheDifference3(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }

    public static void main(String[] args) {
        String s = "ae";
        String t = "aea";
        System.out.println(findTheDifference(t, s));
    }
}
