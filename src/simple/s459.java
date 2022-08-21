package simple;

public class s459 {
    //todo

    public static boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    public static void main(String[] args) {
        String s = "aba";
//        System.out.println(repeatedSubstringPattern(s));
        System.out.println((s + s).indexOf(s, 1));
    }
}
