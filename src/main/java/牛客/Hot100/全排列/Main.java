package 牛客.Hot100.全排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 @Author NewTong
 @Date 2025/3/12 -14:36
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> path, int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // 当前数字没使用过，则加入路径
                path.add(nums[i]);
                used[i] = true;
                backtrack(ans, path, nums, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

}
