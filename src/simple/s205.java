package simple;

import java.util.HashMap;

public class s205 {

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> maps = new HashMap<>();
        HashMap<Character, Character> mapt = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if ((maps.containsKey(s1) && maps.get(s1) != t1) || (mapt.containsKey(t1) && mapt.get(t1) != s1)) {
                return false;
            } else {
                maps.put(s1, t1);
                mapt.put(t1, s1);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";

        String s1 = "paper";
        String t1 = "title";

        System.out.println(isIsomorphic(s, t));
    }
}
