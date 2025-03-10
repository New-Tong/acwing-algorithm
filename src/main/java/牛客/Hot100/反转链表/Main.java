package 牛客.Hot100.反转链表;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 @Author NewTong
 @Date 2025/3/10 -12:50
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
        ListNode reverseList = reverseList(head.next);
        while (reverseList != null) {
            printWriter.print(reverseList.val + ",");
            reverseList = reverseList.next;
        }
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
    }

    // 迭代法
//    public static ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }

    // 递归法
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 把新的链表头节点返回
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
