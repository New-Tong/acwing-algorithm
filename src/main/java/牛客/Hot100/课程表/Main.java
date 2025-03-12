package 牛客.Hot100.课程表;

import java.util.*;

/**
 @Author NewTong
 @Date 2025/3/12 -13:14
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            if (!map.containsKey(prerequisite[1])) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisite[0]);
                map.put(prerequisite[1], list);
            } else {
                map.get(prerequisite[1]).add(prerequisite[0]);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // 每学一门课程就count++
            count++;
            if (map.containsKey(cur)) {
                List<Integer> pres = map.get(cur);
                for (int pre : pres) {
                    inDegree[pre]--;
                    if (inDegree[pre] == 0) {
                        queue.offer(pre);
                    }
                }
            }
        }
        if (count == numCourses) {
            return true;
        }
        return false;
    }
}
