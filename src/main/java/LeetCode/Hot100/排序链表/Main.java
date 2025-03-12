package LeetCode.Hot100.排序链表;

import java.io.*;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/10 -20:50
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
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        ListNode sortList = sortList(head.next);
        while (sortList != null) {
            printWriter.print(sortList.val + ",");
            sortList = sortList.next;
        }
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
    }

    public static ListNode sortList(ListNode head) {
        // 首先判断链表是否为空或者只有一个节点，如果是，直接返回该链表
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针找中点
        ListNode middle = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        return mergeTwoListNodes(left, right);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }

    public static ListNode mergeTwoListNodes(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
