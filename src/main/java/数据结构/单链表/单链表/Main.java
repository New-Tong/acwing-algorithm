package 数据结构.单链表.单链表;

import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/21 -15:00
 * @Description
 */
public class Main {
    static int head = -1, idx = 0, N = 100010;
    static int[] e = new int[N], ne = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            String str = scanner.next();
            if ("H".equals(str)) {
                int val = scanner.nextInt();
                addToHead(val);
            } else if ("I".equals(str)) {
                int k = scanner.nextInt();
                int val = scanner.nextInt();
                insert(k - 1, val);
            } else {
                int k = scanner.nextInt();
                if (k == 0) {
                    head = ne[head];
                } else {
                    remove(k - 1);
                }
            }
        }
        for (int i = head; i != -1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }
    }

    public static void addToHead(int v) {
        e[idx] = v;
        ne[idx] = head;
        head = idx;
        idx++;
    }

    public static void insert(int k, int v) {
        e[idx] = v;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }


    public static void remove(int k) {
        ne[k] = ne[ne[k]];
    }

}
