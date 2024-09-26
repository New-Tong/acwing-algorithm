package 数据结构.Trie.Trie字符串统计.Map实现;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author NewTong
 * @Date 2024/9/26 -9:16
 * @Description
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().split(" ")[0]);
        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            String[] str = br.readLine().split(" ");
            if (str[0].equals("I")) {
                Integer i = map.get(str[1]);
                map.put(str[1], i == null ? 1 : i + 1);
            } else if (str[0].equals("Q")) {
                pw.println(map.get(str[1]) == null ? 0 : map.get(str[1]));
            }
        }
        pw.flush();
        br.close();
        pw.close();
    }
}
