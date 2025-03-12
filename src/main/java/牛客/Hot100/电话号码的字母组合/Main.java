package 牛客.Hot100.电话号码的字母组合;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 @Author NewTong
 @Date 2025/3/12 -15:32
 @Description
 */
public class Main {
    public static void main(String[] args) throws IOException {

    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) {
            return combinations;
        }
        backtrack(phoneMap, digits.toCharArray(), combinations, 0, new StringBuilder());
        return combinations;
    }

    public void backtrack(Map<Character, String> phoneMap,
                          char[] digitArray, List<String> combinations, int index, StringBuilder stringBuilder) {
        if (index == digitArray.length) {
            combinations.add(stringBuilder.toString());
        } else {
            char digit = digitArray[index];
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                char c = letters.charAt(i);
                backtrack(phoneMap, digitArray, combinations, index + 1, stringBuilder.append(c));
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
}
