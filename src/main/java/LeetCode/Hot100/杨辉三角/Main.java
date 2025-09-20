package LeetCode.Hot100.杨辉三角;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 @Author NewTong
 @Date 2025/3/16 -12:18
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        if (numRows == 1) return ans;
        ans.add(Arrays.asList(1, 1));
        if (numRows == 2) return ans;

        for (int i = 3; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == (i - 1)) {
                    temp.add(1);
                } else {
                    temp.add(ans.get(i - 2).get(j - 1) + ans.get(i - 2).get(j));
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
