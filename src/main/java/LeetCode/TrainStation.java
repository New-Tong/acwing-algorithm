package LeetCode;

import java.util.*;

public class TrainStation {
    public static int solve(int n, int[] sequence) {
        Stack<Integer> stack = new Stack<>();
        int i = 1; // 当前应进站的火车编号
        int j = 0; // 出站序列指针
        int fromExit1 = 0; // 从出站口1离开的数量（即进过栈的）

        while (j < n) {
            int target = sequence[j];

            // 如果栈顶可以出站（出站口1）
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                fromExit1++; // 这辆车是从出站口1出去的
                j++;
            }
            // 如果当前火车可以直接走出站口2（不入栈）
            else if (target == i) {
                // 直接通过，不入栈，走的是出站口2
                i++;
                j++;
                // fromExit1 不变（因为没进栈）
            }
            // 否则：需要先把前面的火车入栈，直到 i == target
            else if (target > i) {
                // 把 i 到 target-1 都先压入栈
                while (i < target) {
                    stack.push(i);
                    fromExit1++; // 这些车进了栈，将来从出站口1出
                    i++;
                }
                // 此时 i == target，可以直接走口2
                i++;
                j++;
            }
            // 剩下的情况：target < i 且不在栈顶 → 非法
            else {
                return -1;
            }
        }

        return fromExit1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入火车数量 n: ");
        int n = sc.nextInt();
        int[] seq = new int[n];
        System.out.println("输入出站序列:");
        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
        }

        int result = solve(n, seq);
        if (result == -1) {
            System.out.println("非法序列！");
        } else {
            int fromExit2 = n - result;
            System.out.println("合法序列！");
            System.out.println("从出站口1离开的火车数量: " + result);
            System.out.println("从出站口2离开的火车数量: " + fromExit2);
        }
        sc.close();
    }
}