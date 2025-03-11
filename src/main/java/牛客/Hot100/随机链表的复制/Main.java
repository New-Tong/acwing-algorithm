package 牛客.Hot100.随机链表的复制;

import org.w3c.dom.Node;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 @Author NewTong
 @Date 2025/3/10 -19:28
 @Description
 */
public class Main {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        //[7,null],[13,0],[11,4],[10,2],[1,0]
        int n = Integer.parseInt(bufferedReader.readLine());
        Node head = new Node(-1);
        Node node = copyRandomList2(head);
    }

    public static Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        Map<Integer, Node> oldMap = new HashMap<>();
        Map<Node, Integer> nodeMap = new HashMap<>();
        int index = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            oldMap.put(index, cur);
            nodeMap.put(cur, index++);
        }
        Node newHead = new Node(head.val);
        Map<Integer, Node> newMap = new HashMap<>();
        newMap.put(0, newHead);
        Node pre = newHead;
        for (int i = 1; i < index; i++) {
            Node cur = new Node(oldMap.get(i).val);
            pre.next = cur;
            pre = cur;
            newMap.put(i, cur);
        }
        // 已经串联在一起了，但是random的值还没有设置
        for (int i = 0; i < index; i++) {
            if (oldMap.get(i).random != null) {
                newMap.get(i).random = newMap.get(nodeMap.get(oldMap.get(i).random));
            }
        }
        return newHead;
    }

    public static Node copyRandomList2(Node head) {
        if (head == null) return null;
        // 交替创建节点并插入
        for (Node cur = head; cur != null; cur = cur.next.next) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
        }

        // 遍历链表，设置random指针
        for (Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }

        // 拆分链表
        Node newHead = head.next;
        Node cur = head;
        for (;cur.next.next != null; cur = cur.next) {
            Node copy = cur.next;
            cur.next = copy.next;
            copy.next = copy.next.next;
        }
        cur.next = null;
        return newHead;
    }
}
