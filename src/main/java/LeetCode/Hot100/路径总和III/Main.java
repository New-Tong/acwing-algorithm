package LeetCode.Hot100.路径总和III;

/**
 @Author NewTong
 @Date 2025/3/12 -9:19
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

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 以当前节点为起始节点的路径和等于targetSum的个数
        int ret = findPath(root, targetSum);
        // 递归求解左子树和右子树中，路径和等于targetSum的个数
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int findPath(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        if (root.val == targetSum) {
            ret++;
        }
        ret += findPath(root.left, targetSum - root.val);
        ret += findPath(root.right, targetSum - root.val);
        return ret;
    }

}
