package Acwing.数据结构.栈.表达式求值;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author NewTong
 * @Date 2024/9/23 -8:56
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int x = 0, j = i;
                while (j < length && Character.isDigit(s.charAt(j))) x = x * 10 + s.charAt(j++) - '0';
                nums.push(x);
                i = j - 1;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') eval(nums, ops);
                ops.pop();
            } else if (ops.isEmpty()) {
                ops.push(c);
            } else {
                while (!ops.isEmpty() && ops.peek() != '(' && map.get(ops.peek()) >= map.get(c)) eval(nums, ops);
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) eval(nums, ops);
        System.out.println(nums.pop());
    }

    public static void eval(Stack<Integer> nums, Stack<Character> ops) {
        int a = nums.pop(), b = nums.pop();
        char c = ops.pop();
        if (c == '+') nums.push(b + a);
        if (c == '-') nums.push(b - a);
        if (c == '*') nums.push(b * a);
        if (c == '/') nums.push(b / a);
    }
}
