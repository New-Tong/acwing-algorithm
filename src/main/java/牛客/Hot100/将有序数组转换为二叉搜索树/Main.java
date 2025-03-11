package 牛客.Hot100.将有序数组转换为二叉搜索树;

/**
 @Author NewTong
 @Date 2025/3/11 -19:59
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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] left = new int[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }
        int[] right = new int[nums.length - mid - 1];
        for (int i = mid + 1; i < nums.length; i++) {
            right[i - mid - 1] = nums[i];
        }
        TreeNode leftNode = sortedArrayToBST(left);
        TreeNode rightNode = sortedArrayToBST(right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
