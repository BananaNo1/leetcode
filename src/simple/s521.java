package simple;

import java.util.HashMap;

public class s521 {

    public int findLUSlength1(String a, String b) {
        HashMap<String, Integer> map = new HashMap();
        for (String s : new String[]{a, b}) {
            for (int i = 0; i < (1 << s.length()); i++) {
                String t = "";
                for (int j = 0; j < s.length(); j++) {
                    if (((i >> j) & 1) != 0) {
                        t += s.charAt(j);
                    }
                }
                if (map.containsKey(t))
                    map.put(t, map.get(t) + 1);
                else
                    map.put(t, 1);
            }
        }
        int res = -1;
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                res = Math.max(res, s.length());
            }
        }
        return res;
    }


    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {

    }
}
