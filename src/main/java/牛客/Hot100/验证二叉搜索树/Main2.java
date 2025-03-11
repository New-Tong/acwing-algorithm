package 牛客.Hot100.验证二叉搜索树;


import java.util.ArrayList;
import java.util.List;

/**
 @Author NewTong
 @Date 2025/3/11 -20:03
 @Description
 */
public class Main2 {
    public class TreeNode {
        int val;
        Main2.TreeNode left;
        Main2.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, Main2.TreeNode left, Main2.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        // 左边的所有值都不能超过当前值，右边的所有值都不能小于当前值
        return isValidBST(root.left, min, val) && min < val && val < max && isValidBST(root.right, val, max);
    }
}
