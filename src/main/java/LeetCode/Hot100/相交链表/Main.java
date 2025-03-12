package LeetCode.Hot100.相交链表;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @Author NewTong
 * @Date 2025/3/10-12:37
 * @Description
 */

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {

    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        int count = 0;
        while (count < 3) {
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
            if (pA == null) {
                count++;
                pA = headB;
            }
            if (pB == null) {
                count++;
                pB = headA;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}