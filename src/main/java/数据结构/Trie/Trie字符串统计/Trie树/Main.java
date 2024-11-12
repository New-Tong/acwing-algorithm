package 数据结构.Trie.Trie字符串统计.Trie树;

import java.io.*;

/**
 * @Author NewTong
 * @Date 2024/9/26 -9:32
 * @Description
 */
public class Main {
    static int N = 100010, idx = 0;
    static int[][] son = new int[N][26];
    static int[] cnt = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine().split(" ")[0]);
        while (n-- > 0) {
            String[] strings = bufferedReader.readLine().split(" ");
            if (strings[0].equals("I")) {
                insert(strings[1]);
            } else {
                printWriter.write(query(strings[1]) + "\n");
            }
        }
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    static void insert(String s) {
        int p = 0;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            int u = c - 'a';
            if (son[p][u] == 0) {
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
        cnt[p]++;
    }

    static int query(String s) {
        int p = 0;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            int u = c - 'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }
        return cnt[p];
    }
}
