package LeetCode.Hot100.单词搜索;

/**
 @Author NewTong
 @Date 2025/3/12 -21:34
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0, used)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    public boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] used) {
        // 边界条件
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        // 非边界条件
        // 当前有两种选择，选择和不选择
        used[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newI = i + dx[k];
            int newJ = j + dy[k];
            if (dfs(board, newI, newJ, word, index + 1, used)) {
                return true;
            }
        }
        used[i][j] = false;
        return false;
    }
}
