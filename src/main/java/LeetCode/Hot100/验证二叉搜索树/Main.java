package LeetCode.Hot100.验证二叉搜索树;


import java.util.ArrayList;
import java.util.List;

/**
 @Author NewTong
 @Date 2025/3/11 -20:03
 @Description
 */
public class Main {
    public class TreeNode {
        int val;
        Main.TreeNode left;
        Main.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, Main.TreeNode left, Main.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        
    }

    public boolean isValidBST(TreeNode root) {
        inorderTraversal(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    List<Integer> list = new ArrayList<>();
    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return ;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
}
