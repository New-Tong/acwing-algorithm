package LeetCode.Hot100.只出现一次的数字;

import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/18 -14:31
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
