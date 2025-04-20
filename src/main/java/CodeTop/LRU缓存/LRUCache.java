package CodeTop.LRU缓存;


import java.util.HashMap;
import java.util.function.Predicate;

/**
 @Author NewTong
 @Date 2025/4/10 -9:35
 @Description
 */
public class LRUCache {
    int capacity;
    int size;
    DListNode head;
    DListNode tail;
    HashMap<Integer, DListNode> hashMap;

    public LRUCache(int capacity) {
        head = new DListNode();
        tail = new DListNode();
        hashMap = new HashMap<>(capacity);
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            DListNode node = hashMap.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            DListNode dListNode = hashMap.get(key);
            moveToHead(dListNode);
            dListNode.val = value;
            return;
        }
        addNewNode(new DListNode(key, value));
    }

    public void removeNode(DListNode node) {
        hashMap.remove(node.key);
        DListNode pre = node.pre;
        DListNode next = node.next;
        pre.next = next;
        next.pre = pre;
        node.pre = null;
        node.next = null;
        size--;
    }

    public void addNewNode(DListNode node) {
        DListNode headNext = head.next;
        node.next = headNext;
        node.pre = head;
        head.next = node;
        headNext.pre = node;
        hashMap.put(node.key, node);
        size++;
        if (size == capacity + 1) {
            removeNode(tail.pre);
        }
    }

    public void moveToHead(DListNode node) {
        DListNode pre = node.pre;
        DListNode next = node.next;
        pre.next = next;
        next.pre = pre;
        DListNode headNext = head.next;
        node.pre = head;
        node.next = headNext;
        head.next = node;
        headNext.pre = node;
    }
}