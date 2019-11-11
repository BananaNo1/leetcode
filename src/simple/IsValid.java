package simple;

import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName IsValid
 * @Description 有效的括号
 * @Author leis
 * @Date 2019/7/12 15:39
 * @Version 1.0
 **/
public class IsValid {

    static HashMap<Character, Character> map = new HashMap<>();

    public IsValid() {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.empty()) {
                    return false;
                }
//                char topElement = stack.empty() ? '#' : stack.pop();
                char top = stack.pop();
                if (map.get(c) != top) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("["));
    }
}
