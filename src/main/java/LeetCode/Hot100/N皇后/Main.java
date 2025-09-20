package LeetCode.Hot100.N皇后;

import java.util.ArrayList;
import java.util.List;

/**
 @Author NewTong
 @Date 2025/3/13 -9:43
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        boolean[][] board = new boolean[n][n];
        List<List<String>> res = new ArrayList<>();
        backtrack(n, res, 0, board);
        return res;
    }

    public void backtrack(int n, List<List<String>> res, int row, boolean[][] board) {
        // 边界条件
        if (row == n) {
            res.add(getPath(board));
            return;
        }
        // 非边界逻辑
        // 遍历每一列
        for (int i = 0; i < n; i++) {
            if (isValid(row, i, board)) {
                board[row][i] = true;
                backtrack(n, res, row + 1, board);
                board[row][i] = false;
            }
        }
    }

    public List<String> getPath(boolean[][] board) {
        List<String> path = new ArrayList<>();
        for (boolean[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : row) {
                if (b) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            path.add(sb.toString());
        }
        return path;
    }


    public boolean isValid(int row, int col, boolean[][] board) {
        // 1.检查当前行
        for (int i = 0; i < col; i++) {
            if (board[row][i]) {
                return false;
            }
        }
        // 2.检查当前列
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        // 3.检查左下角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        // 4.检查右下角
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }
        return true;
    }
}
