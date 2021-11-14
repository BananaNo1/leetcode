package simple;

import java.util.HashMap;

public class s345 {

    public String reverseVowels(String s) {
        HashMap<Character, Integer> mapC = new HashMap<>();
        mapC.put('a', 1);
        mapC.put('e', 1);
        mapC.put('i', 1);
        mapC.put('o', 1);
        mapC.put('u', 1);
        mapC.put('A', 1);
        mapC.put('E', 1);
        mapC.put('I', 1);
        mapC.put('O', 1);
        mapC.put('U', 1);
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (left <= right) {
            while (left < s.length() && !mapC.containsKey(arr[left]))
                left++;
            while (right > 0 && !mapC.containsKey(arr[right]))
                right--;
            if (left > right)
                break;
            char tem = arr[left];
            arr[left] = arr[right];
            arr[right] = tem;
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {

    }
}
