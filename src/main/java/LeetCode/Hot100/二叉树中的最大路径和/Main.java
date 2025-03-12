package LeetCode.Hot100.二叉树中的最大路径和;

/**
 @Author NewTong
 @Date 2025/3/12 -10:46
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

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // 以当前节点为拐点，分别求出左子树最大路径和，右子树最大路径和，再加上当前节点的值，返回最大值
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        maxSum = Math.max(maxSum, leftMax + rightMax + root.val);
        return Math.max(Math.max(leftMax, rightMax) + root.val, 0);
    }
}
