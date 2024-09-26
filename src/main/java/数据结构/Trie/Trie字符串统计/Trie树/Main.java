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
            String[] str = bufferedReader.readLine().split(" ");
            if (str[0].equals("I")) {
                insert(str[1]);
            } else if (str[0].equals("Q")) {
                query(str[1]);
            }
        }
        printWriter.write(n);
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
    }

    public static void insert(String string) {
    }

    public static void query(String string) {
    }
}
