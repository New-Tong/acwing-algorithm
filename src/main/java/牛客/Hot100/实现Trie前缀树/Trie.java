package 牛客.Hot100.实现Trie前缀树;

/**
 @Author NewTong
 @Date 2025/3/12 -14:20
 @Description
 */
public class Trie {
    Trie[] next;
    boolean isEnd;
    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            int idx = c - 'a';
            if (node.next[idx] == null) {
                node.next[idx] = new Trie();
            }
            node = node.next[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.next[idx] == null) {
                return false;
            }
            node = node.next[idx];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.next[idx] == null) {
                return false;
            }
            node = node.next[idx];
        }
        return true;
    }
}
