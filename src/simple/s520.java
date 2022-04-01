package simple;

public class s520 {

    public static boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i);
            if (65 <= c && c <= 90) {
                count++;
            }
        }
        int n = word.charAt(0);
        if (count == word.length() || (count == 1 && n >= 65 && n <= 90) || count == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        String word = "FlaG";
        System.out.println(detectCapitalUse(word));
    }
}
