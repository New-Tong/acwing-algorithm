package LeetCode.Hot100.组合总和;

import java.util.ArrayList;
import java.util.List;

/**
 @Author NewTong
 @Date 2025/3/12 -16:57
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        backtrack(candidates, target, 0, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int start, int sum, List<Integer> path, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                continue;
            }
            path.add(candidates[i]);
            backtrack(candidates, target, i, sum + candidates[i], path, res);
            path.remove(path.size() - 1);
        }
    }
}
