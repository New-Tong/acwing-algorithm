package 牛客.Hot100.腐烂的橘子;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 @Author NewTong
 @Date 2025/3/12 -12:14
 @Description
 */
public class Main {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                printWriter.print(grid[i][j] + " ");
            }
            printWriter.println();
        }
        printWriter.println();
        orangesRotting(grid);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                printWriter.print(grid[i][j] + " ");
            }
            printWriter.println();
        }
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
    }

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshOrange = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }
        int time = 0;
        while (freshOrange > 0 && !queue.isEmpty()) {
            time++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        freshOrange--;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        if (freshOrange != 0) return -1;
        return time;
    }
}
