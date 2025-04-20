package CodeTop.反转链表;

/**
 @Author NewTong
 @Date 2025/4/10 -11:19
 @Description
 */
public class Main {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next==null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        cur.next = pre;
        return cur;
    }
}
