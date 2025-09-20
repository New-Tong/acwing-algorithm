package LeetCode.Hot100.划分字母区间;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 @Author NewTong
 @Date 2025/3/16 -10:41
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<Integer> partitionLabels(String s) {
        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < charArray.length; i++) {
            int index = charArray[i] - 'a';
            lastIndex[index] = Math.max(lastIndex[index], i);
        }
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        for (int i = 0; i < charArray.length; i++) {
            right = Math.max(right, lastIndex[charArray[i] - 'a']);
            if (i == right) {
                // 分割
                res.add(right - left + 1);
                left = i + 1;
            }
        }
        return res;
    }
}
