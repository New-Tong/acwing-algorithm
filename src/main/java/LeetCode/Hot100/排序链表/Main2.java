package LeetCode.Hot100.排序链表;

import java.io.*;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/10 -20:50
 @Description
 */

public class Main2 {
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

    // 自底向上的归并排序1
    public static ListNode sortList(ListNode head) {
        // 首先判断链表是否为空或者只有一个节点，如果是，直接返回该链表
        if (head == null || head.next == null) {
            return head;
        }
        // 先获取链表的长度
        int length = getLength(head);
        // step 1：定义一个虚拟节点，指向头节点，方便后续操作
        ListNode dummy = new ListNode(-1, head);
        // step 2：定义一个步长，步长从1开始，每次步长翻倍，直到步长大于等于链表长度
        int step = 1;
        while (step < length) {
            // 拆分链表为两部分，然后进行归并排序
            ListNode newTail = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode head1 = cur.next;
                // 拆分链表为两部分
                ListNode head2 = splitListNode(head1, step);
                cur = splitListNode(head2, step);
                // cur 就是下一次循环的起始节点
                // 进行归并排序
                ListNode[] mergedListNode = mergeTwoListNodes(head1, head2);
                // 将归并后的链表合并到原链表中
                ListNode mergedHead = mergedListNode[0];
                ListNode mergedTail = mergedListNode[1];
                newTail.next = mergedHead;
                newTail = mergedTail;
            }
            step <<= 1;
        }
        return dummy.next;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static ListNode splitListNode(ListNode head, int n) {
        for (int i = 0; i < n - 1 && head != null; i++) {
            head = head.next;
        }
        if (head == null || head.next == null) return null;
        ListNode secondeListNode = head.next;
        head.next = null;
        return secondeListNode;
    }

    public static ListNode[] mergeTwoListNodes(ListNode listNode1, ListNode listNode2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                cur.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                cur.next = listNode2;
                listNode2 = listNode2.next;
            }
            cur =cur.next;
        }
        cur.next = listNode1 == null ? listNode2 : listNode1;
        while (cur.next != null) {
            cur = cur.next;
        }
        return new ListNode[]{dummy.next, cur};
    }
}
