package 牛客.Hot100.二叉树的层序遍历;

import java.util.*;

/**
 @Author NewTong
 @Date 2025/3/11 -19:33
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> m = new HashMap<>();
        map.put(root, 0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        res.add(new ArrayList<>(Arrays.asList(root.val)));
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int level = map.get(cur);
            List<Integer> list = m.getOrDefault(level + 1, new ArrayList<>());
            if (cur.left != null) {
                map.put(cur.left, level + 1);
                list.add(cur.left.val);
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                map.put(cur.right, level + 1);
                list.add(cur.right.val);
                queue.offer(cur.right);
            }
            m.put(level + 1, list);
        }
        for (int i = 1; i < m.size(); i++) {
            res.add(m.get(i));
        }
        return res;
    }
}
