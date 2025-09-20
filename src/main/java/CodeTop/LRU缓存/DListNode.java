package CodeTop.LRU缓存;

/**
 @Author NewTong
 @Date 2025/4/10 -9:36
 @Description
 */
public class DListNode {
    int key;
    int val;
    DListNode pre;
    DListNode next;

    public DListNode(int key, int val, DListNode pre, DListNode next) {
        this.key = key;
        this.val = val;
        this.pre = pre;
        this.next = next;
    }

    public DListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public DListNode(){}
}
