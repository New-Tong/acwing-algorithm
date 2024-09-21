package 数据结构.栈.模拟栈;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author NewTong
 * @Date 2024/9/21 -16:40
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        while (n-- > 0) {
            String str = scanner.next();
            if ("push".equals(str)) {
                int x = scanner.nextInt();
                stack.push(x);
            } else if ("pop".equals(str)) {
                stack.pop();
            } else if ("query".equals(str)) {
                System.out.println(stack.peek());
            } else if ("empty".equals(str)) {
                System.out.println(stack.isEmpty() ? "YES" : "NO");
            }
        }
    }
}
