package 牛客.Hot100.两数相加;

import java.io.*;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/10 -16:00
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
        ListNode mergedList = addTwoNumbers(list1, list2);
        while (mergedList != null) {
            printWriter.print(mergedList.val + ",");
            mergedList = mergedList.next;
        }
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int val = val1 + val2 + carry;
            carry = val / 10;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return newHead.next;
    }
}
