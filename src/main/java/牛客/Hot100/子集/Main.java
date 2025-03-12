package 牛客.Hot100.子集;

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
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, 0);
        ans.add(new ArrayList<>());
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> path, int[] nums,int index) {
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            backtrack(ans, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
