package 数据结构.堆.模拟堆;

import java.io.*;
import java.util.Arrays;


/**
 * heap : 堆
 * ph : 存放第k个插入的结点在heap中的下标
 * hp : 存放堆中点的插入次序
 */
class Main {
    static int N = 100010, size = 0, idx = 0;
    static int[] heap = new int[N], hp = new int[N], ph = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()[0];
        while (n-- > 0) {
            String[] s = bufferedReader.readLine().split(" ");
            switch (s[0]) {
                case "I":
                    insert(Integer.parseInt(s[1]));
                    break;
                case "PM":
                    printWriter.println(heap[1]);
                    break;
                case "DM":
                    deleteMin();
                    break;
                case "D":
                    delete(Integer.parseInt(s[1]));
                    break;
                case "C":
                    update(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                    break;
            }
        }
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static void up(int x) {
        while (x / 2 > 0 && heap[x / 2] > heap[x]) {
            heap_swap(x / 2, x);
            x /= 2;
        }
    }

    public static void update(int k, int x) {
        heap[ph[k]] = x;
        down(ph[k]);
        up(ph[k]);
    }

    public static void down(int x) {
        int t = x;
        if (x * 2 <= size && heap[x * 2] < heap[t]) t = x * 2;
        if (x * 2 + 1 <= size && heap[x * 2 + 1] < heap[t]) t = x * 2 + 1;
        if (t != x) {
            heap_swap(t, x);
            down(t);
        }
    }

    public static void insert(int x) {
        heap[++size] = x;
        ph[++idx] = size;
        hp[size] = idx;
        up(size);
    }

    public static void delete(int k) {
        int t = ph[k];
        heap_swap(t, size--);
        down(t);
        up(t);
    }

    public static void deleteMin() {
        heap_swap(1, size--);
        down(1);
    }

    public static void heap_swap(int a, int b) {
        int tmp = ph[hp[a]];
        ph[hp[a]] = ph[hp[b]];
        ph[hp[b]] = tmp;
        tmp = hp[a];
        hp[a] = hp[b];
        hp[b] = tmp;
        tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

}
