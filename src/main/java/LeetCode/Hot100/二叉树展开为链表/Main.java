package LeetCode.Hot100.二叉树展开为链表;

import java.util.ArrayList;
import java.util.List;

/**
 @Author NewTong
 @Date 2025/3/11 -20:58
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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1), cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
        list.get(list.size() - 1).right = null;
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}
