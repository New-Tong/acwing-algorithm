package LeetCode.Hot100.合并两个有序链表;

import java.io.*;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/10 -15:53
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
        int[] array1 = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] array2 = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        ListNode list1 = new ListNode();
        ListNode cur1 = list1;
        for (int i = 0; i < array1.length; i++) {
            cur1.next = new ListNode(array1[i]);
            cur1 = cur1.next;
        }
        ListNode list2 = new ListNode();
        ListNode cur2 = list2;
        for (int i = 0; i < array2.length; i++) {
            cur2.next = new ListNode(array1[i]);
            cur2 = cur2.next;
        }
        ListNode mergedList = mergeTwoLists(list1, list2);
        while (mergedList != null) {
            printWriter.print(mergedList.val + ",");
            mergedList = mergedList.next;
        }
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        cur.next = list1 != null ? list1 : list2;
        return newHead.next;
    }
}
