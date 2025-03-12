package LeetCode.Hot100.子集;

import java.util.*;

/**
 @Author NewTong
 @Date 2025/3/12 -14:57
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int[] nums, int i, List<Integer> path, List<List<Integer>> res) {
        // 边界条件
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 非边界条件
        // 当前有两种选择，选择和不选择
        // 1.不选择
        backtrack(nums, i + 1, path, res);
        // 2.选择
        path.add(nums[i]);
        backtrack(nums, i + 1, path, res);
        path.remove(path.size() - 1);
    }

}
