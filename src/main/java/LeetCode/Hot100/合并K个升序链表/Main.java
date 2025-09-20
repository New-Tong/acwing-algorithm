package LeetCode.Hot100.合并K个升序链表;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 @Author NewTong
 @Date 2025/3/11 -9:17
 @Description
 */
public class Main {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
//        int n = Integer.parseInt(bufferedReader.readLine());
        ListNode[] lists = new ListNode[2];
//        for (int i = 0; i < n; i++) {
//            int[] array = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
//            ListNode head = new ListNode();
//            ListNode cur = head;
//            for (int j = 0; j < array.length; j++) {
//                cur.next = new ListNode(array[j]);
//                cur = cur.next;
//            }
//            lists[i] = head.next;
//        }
        lists[0] = new ListNode(-2, new ListNode(-1, new ListNode(-1, new ListNode(-1))));
        lists[1] = null;
        ListNode res = mergeKLists(lists);
        while (res != null) {
            printWriter.print(res.val + ",");
            res = res.next;
        }
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            while (list != null) {
                queue.offer(list);
                list = list.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }

}
