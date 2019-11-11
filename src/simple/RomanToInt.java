package simple;

import java.util.HashMap;

/**
 * @ClassName RomanToInt
 * @Description TODO
 * @Author leis
 * @Date 2019/7/12 11:23
 * @Version 1.0
 **/
public class RomanToInt {

    public static int romanToInt(String s) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chars = s.toCharArray();
        int pre = 1000;
        for (char c : chars) {
            Integer current = map.get(c);
            result += current;
            if (current > pre) {
                result = result - (2 * pre);
            }
            pre = current;
        }
//        int i = chars.length - 1, j = chars.length - 2;
//        while (i >= 0 && j >= 0) {
//            int fir = map.get(chars[i]);
//            int sec = map.get(chars[j]);
//            i = i - 2;
//            j = j - 2;
//            int a = sec >= fir ? sec + fir : fir - sec;
//            result = result + a;
//        }
//        if (j >= 0 && i >= 0) {
//            int sec = map.get(chars[j]);
//            int fir = map.get(chars[i]);
//            int a = sec >= fir ? sec + fir : fir - sec;
//            result += a;
//        } else if (i >= 0) {
//            int fir = map.get(chars[i]);
//            result += fir;
//        }
        return result;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
