package simple;

import java.util.ArrayList;
import java.util.List;

public class s500 {

    public static String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        String rowInx = "12210111011122000010020202";
        for (String word : words) {
            boolean isValid = true;
            char idx = rowInx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 1; i < word.length(); i++) {
                if (rowInx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(word);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] ans = findWords(words);
        for (String an : ans) {
            System.out.print(an + " ");
        }
    }

}
