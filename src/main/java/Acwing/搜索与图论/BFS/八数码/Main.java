package Acwing.搜索与图论.BFS.八数码;

import java.io.*;
import java.util.*;

class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    // 上下左右
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(bufferedReader.readLine().split(" ")).forEach(sb::append);
        Queue<String> queue = new LinkedList<>();
        queue.add(sb.toString());
        Map<String, Integer> step = new HashMap<>();
        step.put(sb.toString(), 0);
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if (poll.equals("12345678x")) {
                printWriter.println(step.get(poll));
                printWriter.flush();
                bufferedReader.close();
                printWriter.close();
                return;
            }
            int index = poll.indexOf('x');
            int a = index / 3;
            int b = index % 3;
            for (int i = 0; i < 4; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];
                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                    StringBuilder temp = new StringBuilder(poll);
                    char t = temp.charAt(index);
                    temp.setCharAt(index, temp.charAt(nx * 3 + ny));
                    temp.setCharAt(nx * 3 + ny, t);
                    String s = temp.toString();
                    if (!step.containsKey(s)) {
                        queue.add(s);
                        step.put(s, step.get(poll) + 1);
                    }
                }
            }
        }
        printWriter.println(-1);
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }
}