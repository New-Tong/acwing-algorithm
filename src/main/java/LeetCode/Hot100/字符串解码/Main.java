package LeetCode.Hot100.字符串解码;

import java.util.*;

/**
 @Author NewTong
 @Date 2025/3/13 -16:58
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Deque<String> charStack = new LinkedList<>();
        Deque<Integer> numStack = new LinkedList<>();
        char[] nums = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        List<Character> numList = new ArrayList<>();
        for (char num : nums) {
            numList.add(num);
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i ++) {
            if (numList.contains(charArray[i])) {
                StringBuilder numString = new StringBuilder();
                while (numList.contains(charArray[i])) {
                    // 从当前开始就是数字
                    numString.append(charArray[i]);
                    i++;
                }
                numStack.push(Integer.parseInt(numString.toString()));
                i--;
            } else if (charArray[i] == ']') {
                // 需要进行一次运算
                StringBuilder chars = new StringBuilder();
                while (!charStack.peek().equals("[")) {
                    chars.append(charStack.pop());
                }
                charStack.pop();
                charStack.push(String.valueOf(chars).repeat(Math.max(0, numStack.pop())));
            } else {
                charStack.push(String.valueOf(charArray[i]));
            }
        }
        while (!charStack.isEmpty()) {
            res.append(charStack.pop());
        }
        return res.reverse().toString();
    }
}
