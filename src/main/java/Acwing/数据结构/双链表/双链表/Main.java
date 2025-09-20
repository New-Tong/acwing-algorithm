package Acwing.数据结构.双链表.双链表;

import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/21 -15:01
 * @Description
 */
public class Main {
    static int N = 100010, idx = 2;
    static int[] ne = new int[N], pre = new int[N], e = new int[N];

    static void init() {
        // 0表示头结点，1表示尾结点
        ne[0] = 1;
        pre[1] = 0;
    }

    // 在k的右侧添加值为v的结点
    static void add(int k, int v) {
        e[idx] = v;
        ne[idx] = ne[k];
        pre[idx] = k;
        pre[ne[k]] = idx;
        ne[k] = idx;
        idx++;
    }

    // 删除第k个结点
    static void remove(int k) {
        ne[pre[k]] = ne[k];
        pre[ne[k]] = pre[k];
    }

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            String str = scanner.next();
            if ("R".equals(str)) {
                int val = scanner.nextInt();
                add(pre[1], val);
            } else if ("D".equals(str)) {
                int k = scanner.nextInt();
                remove(k + 1);
            } else if ("L".equals(str)) {
                int val = scanner.nextInt();
                add(0, val);
            } else if ("IL".equals(str)) {
                int k = scanner.nextInt();
                int val = scanner.nextInt();
                add(pre[k + 1], val);
            } else if ("IR".equals(str)) {
                int k = scanner.nextInt();
                int val = scanner.nextInt();
                add(k + 1, val);
            }
        }
        for (int i = ne[0]; i != 1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }
    }
}
