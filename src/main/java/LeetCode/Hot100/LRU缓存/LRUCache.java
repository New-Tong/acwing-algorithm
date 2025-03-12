package LeetCode.Hot100.LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 @Author NewTong
 @Date 2025/3/11 -15:57
 @Description
 */
public class LRUCache {
    class DListNode {
        int key;
        int value;
        DListNode next;
        DListNode prev;

        public DListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DListNode() {
        }

    }

    private int size;
    private final int capacity;
    Map<Integer, DListNode> map = new HashMap<>();
    private final DListNode head;
    private final DListNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DListNode();
        tail = new DListNode();
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        DListNode dListNode = map.get(key);
        if (dListNode == null) {
            return -1;
        }
        moveToHead(dListNode);
        return dListNode.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 存在这个key，那么直接更新然后移动到头结点
            DListNode dListNode = map.get(key);
            dListNode.value = value;
            moveToHead(dListNode);
        } else {
            // 不存在这个key，先创建节点，然后判断是否超过容量，超过就删除尾结点，然后把当前节点添加到头结点，然后更新map
            DListNode dListNode = new DListNode(key, value);
            map.put(key, dListNode);
            addToHead(dListNode);
            size++;
            if (size > capacity) {
                map.remove(tail.prev.key);
                removeTail();
                size--;
            }
        }
    }

    public void moveToHead(DListNode node) {
        if (node == head.next) {
            return;
        }
        removeNode(node);
        addToHead(node);
    }

    public void addToHead(DListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeTail() {
        DListNode node = tail.prev;
        removeNode(node);
    }

    public void removeNode(DListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
