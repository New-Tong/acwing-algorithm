package 牛客.Hot100.删除链表的倒数第N个结点;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 @Author NewTong
 @Date 2025/3/10 -16:16
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
        int n = Integer.parseInt(bufferedReader.readLine());
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        ListNode newList = removeNthFromEnd(head.next, n);
        while (newList != null) {
            printWriter.print(newList.val + ",");
            newList = newList.next;
        }
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
    }

    // 很好写，但是很慢
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            map.put(index++, cur);
            cur = cur.next;
        }
        System.out.println(index);
        if (index == n) {
            return head.next;
        } else {
            int i = index - n;
            ListNode pre = map.get(i-1);
            pre.next = map.get(i).next;
        }
        return head;
    }

    // 快慢指针
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        int index = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null) {
            if (index < n) {
                fast = fast.next;
                index++;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
