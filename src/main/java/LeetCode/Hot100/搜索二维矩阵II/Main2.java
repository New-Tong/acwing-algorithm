package LeetCode.Hot100.搜索二维矩阵II;

/**
 @Author NewTong
 @Date 2025/3/19 -15:28
 @Description
 */
public class Main2 {
    public static void main(String[] args) {

    }

    // 压缩法
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }

}
