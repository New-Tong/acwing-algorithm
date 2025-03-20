package Acwing.搜索与图论.BFS.走迷宫;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    // 4个方向， 上 右 下 左
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] maze = new int[110][110];
    static boolean[][] vis = new boolean[110][110];
    static int[][] step = new int[110][110];

    public static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = array[0];
        int m = array[1];
        for (int i = 1; i <= n; i++) {
            String[] tmp = bufferedReader.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                maze[i][j] = Integer.parseInt(tmp[j - 1]);
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, 1));
        vis[1][1] = true;
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx > 0 && nx <= n && ny > 0 && ny <= m && !vis[nx][ny] && maze[nx][ny] == 0) {
                    queue.add(new Pair(nx, ny));
                    vis[nx][ny] = true;
                    step[nx][ny] = step[x][y] + 1;
                }
            }
        }
        printWriter.println(step[n][m]);

        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }
}