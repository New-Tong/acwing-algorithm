package Acwing.数据结构.单调栈.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/23 -10:16
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        int n = scanner.nextInt();
        while (n-- > 0) {
            int x = scanner.nextInt();
            while (!stack.isEmpty() && stack.peek()>=x) stack.pop();
            if (stack.isEmpty()){
                System.out.print("-1 ");
                stack.push(x);
                continue;
            }
            else System.out.print(stack.peek() + " ");
            stack.push(x);
        }
    }
}
