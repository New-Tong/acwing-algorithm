package LeetCode.Hot100.旋转图像;

/**
 @Author NewTong
 @Date 2025/3/19 -15:28
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        // 先按水平轴翻转
        int top = 0, bottom = row-1;
        while (top < bottom) {
            for (int j = 0; j < col; j ++) {
                int temp = matrix[top][j];
                matrix[top][j] = matrix[bottom][j];
                matrix[bottom][j] = temp;
            }
            top++;
            bottom--;
        }
        // 再按主对角线翻转
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < i; j ++) {
                // 交换matrix[i][j]和matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
