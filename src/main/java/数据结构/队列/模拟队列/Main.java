package 数据结构.队列.模拟队列;

import java.util.*;

/**
 * @Author NewTong
 * @Date 2024/9/23 -10:04
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> integerDeque = new ArrayDeque<>();
        int n = scanner.nextInt();
        while (n-- >= 0) {
            String[] str = scanner.nextLine().split(" ");
            if (str[0].equals("push")) {
                integerDeque.add(Integer.parseInt(str[1]));
            } else if (str[0].equals("empty")) {
                System.out.println(integerDeque.isEmpty() ? "YES" : "NO");
            } else if (str[0].equals("query")) {
                System.out.println(integerDeque.peekFirst());
            } else if (str[0].equals("pop")) {
                integerDeque.removeFirst();
            }
        }
    }
}
