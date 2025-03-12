package LeetCode.秋招每日一题.用户分组;

import java.io.*;
import java.util.*;

/**
 @Author NewTong
 @Date 2024/12/12 -21:19
 @Description
 */
public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    static final int N = 510;
//    static List<List<Integer>> res;

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            map.put(groupSizes[i], new ArrayList<>());
        }
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            List<Integer> list = map.get(groupSize);
            list.add(i);
            if (list.size() == groupSize) {
                res.add(list.stream().toList());
                list.clear();
            }
        }
        map.forEach((k, v) -> {
            if (!v.isEmpty()) {
                res.add(v);
            }
        });
        return res;
    }

    public static void main(String[] args) throws IOException {
        int[] group = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(group));
        System.out.println(group.length);
        List<List<Integer>> res = groupThePeople(group);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }
}
