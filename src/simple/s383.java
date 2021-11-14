package simple;

public class s383 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            chars[magazine.charAt(i) - 97]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 97;
            chars[idx]--;
            if (chars[idx] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char c = 'a';
//        System.out.println(c - 97);

        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
