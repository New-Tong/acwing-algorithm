package CodeTop.K个一组翻转链表;

import java.io.*;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/4/10 -15:01
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

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

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        ListNode head = new ListNode(array[0], null);
        ListNode cur = head;
        for (int i = 1; i < array.length; i++) {
            int val = array[i];
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = node;
        }
        int k = Integer.parseInt(bufferedReader.readLine());
        reverseKGroup(head, k);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head), pre = dummy, cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < n; i++) {
            if (n - i >= k) {
                // 需要进行翻转
                // 找tail
                ListNode tail = cur;
                for (int q = 0; q < k; q++) {
                    tail = tail.next;
                }
                ListNode re = reverseList(cur, k);
                cur.next = tail;
                pre.next = re;
                pre = cur;
                cur = tail;
            }
            i += k;
        }
        return dummy.next;
    }

    public static ListNode reverseList(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = null, cur = head;
        for (int i = 0; i < k; i++) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        dummy.next.next = cur;
        return pre;
    }
}
