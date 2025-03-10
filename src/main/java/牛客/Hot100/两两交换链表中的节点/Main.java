package 牛客.Hot100.两两交换链表中的节点;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 @Author NewTong
 @Date 2025/3/10 -16:38
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
        int[] array = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        ListNode newList = swapPairs(head.next);
        while (newList != null) {
            printWriter.print(newList.val + ",");
            newList = newList.next;
        }
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
    }

    private static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        while (cur != null && cur.next != null) {
            ListNode nxt = cur.next;
            cur.next = nxt.next;
            nxt.next = cur;
            pre.next = nxt;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
    
}
