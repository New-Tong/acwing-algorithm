package 数据结构.堆.堆排序;

import java.io.*;
import java.util.Arrays;

class Main {

    static int N = 100010, size = 1;
    static int[] heap = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        size = array[0];
        int m = array[1];
        int[] tmp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i <= size; i++) {
            heap[i] = tmp[i - 1];
        }

        for (int i = size / 2; i >= 1; i --) {
            down(i);
        }

        while (m-- > 0) {
            printWriter.print(heap[1] + " ");
            heap[1] = heap[size--];
            down(1);
        }

        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    static void down(int x) {
        int t = x;
        if (x * 2 <= size && heap[x * 2] < heap[t]) t = x * 2;
        if (x * 2 + 1 <= size && heap[x * 2 + 1] < heap[t]) t = x * 2 + 1;
        if (t != x) {
            int tmp = heap[t];
            heap[t] = heap[x];
            heap[x] = tmp;
            down(t);
        }
    }

}
