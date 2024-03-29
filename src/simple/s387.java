package simple;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class s387 {

    public static int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 97] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
//        char c = 'a';
//        System.out.println(c - 97);
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

}
