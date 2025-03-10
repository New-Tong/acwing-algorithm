package 牛客.Hot100.合并区间;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 @Author NewTong
 @Date 2025/3/10 -10:11
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // Read the number of intervals
        int n = Integer.parseInt(bufferedReader.readLine());

        // Read the intervals
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] parts = bufferedReader.readLine().split(",");
            intervals[i][0] = Integer.parseInt(parts[0]);
            intervals[i][1] = Integer.parseInt(parts[1]);
        }

        // Merge the intervals
        int[][] mergedIntervals = merge(intervals);

        // Print the merged intervals
        for (int[] interval : mergedIntervals) {
            printWriter.println(Arrays.toString(interval));
        }

        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
    }

    public static int[][] merge(int[][] intervals) {
        // 先按左边界排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 创建一个结果数组，用于存储合并后的区间
        List<int[]> list = new ArrayList<>();
        // 如果intervals为空，直接返回空数组
        if (intervals.length == 0) {
            return new int[0][0];
        }
        // 如果只有一个区间，直接返回该区间
        if (intervals.length == 1) {
            return intervals;
        }
        // 否则，从第二个区间开始，与第一个区间进行比较，如果有交集，则合并，否则，将第一个区间放入结果数组中，并将第一个区间更新为当前区间
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                // 合并
                current[1] = Math.max(current[1], intervals[i][1]);
                current[0] = Math.min(current[0], intervals[i][0]);
            } else {
                list.add(current);
                current = intervals[i];
            }
        }
        list.add(current);
        return list.toArray(new int[list.size()][]);
    }

}
