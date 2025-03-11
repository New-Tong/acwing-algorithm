package 牛客.Hot100.二叉树的右视图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 @Author NewTong
 @Date 2025/3/11 -20:43
 @Description
 */
public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root,0, map);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            res.add(map.get(i).get(map.get(i).size() - 1));
        }
        return res;
    }

    public void dfs(TreeNode root, int depth, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        dfs(root.left, depth + 1, map);
        dfs(root.right, depth + 1, map);
        List<Integer> list = map.getOrDefault(depth, new ArrayList<>());
        list.add(root.val);
        map.put(depth, list);
    }
}
