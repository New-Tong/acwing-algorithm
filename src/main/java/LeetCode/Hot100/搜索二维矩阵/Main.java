package LeetCode.Hot100.搜索二维矩阵;

/**
 @Author NewTong
 @Date 2025/3/13 -11:17
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // 构造成一个升序数组
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i * m + j] = matrix[i][j];
            }
        }
        return binarySearch(arr, target);
    }

    public boolean binarySearch(int[] arr, int target) {
        int left = -1;
        int right = arr.length;
        // 找到第一个大于等于target的元素，返回索引
        while (left + 1 != right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) right = mid;
            else left = mid;
        }
        return right < arr.length && arr[right] == target;
    }
}
