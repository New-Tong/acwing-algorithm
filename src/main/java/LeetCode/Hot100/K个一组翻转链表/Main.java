package LeetCode.Hot100.K个一组翻转链表;

import java.io.*;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/10 -18:12
 @Description
 */
public class Main {
    public static class ListNode {
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

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(bufferedReader.readLine());
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int j : array) {
            cur.next = new ListNode(j);
            cur = cur.next;
        }
        ListNode res = reverseKGroup(head.next, k);
        while (res != null) {
            printWriter.print(res.val + ",");
            res = res.next;
        }
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode nxt = tail.next;
            ListNode[] reverse = reverseList(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = nxt;
            head = tail.next;
            pre = tail;
        }
        return dummy.next;
    }

    public static ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode pre = null, cur = head;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }
}
