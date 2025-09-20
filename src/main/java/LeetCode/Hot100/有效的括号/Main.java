package LeetCode.Hot100.有效的括号;

import java.util.*;

/**
 @Author NewTong
 @Date 2025/3/13 -15:59
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        char[] leftOps = new char[]{'(', '[', '{'};
        List<Character> leftOpera = new ArrayList<>();
        for (Character leftOp: leftOps) {
            leftOpera.add(leftOp);
        }
        Map<Character, Character> map = new HashMap<>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        map.put(')', '(');
        for (char c : charArray) {
            if (leftOpera.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char poll = stack.pop();
                if (map.get(c) != poll) return false;
            }
        }
        return stack.isEmpty();
    }
}
