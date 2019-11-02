package question0208_implement_trie_prefix_tree;

import java.util.HashMap;

/**
 * 执行用时：140ms，击败92.77%。消耗内存：52.5MB，击败91.61%。
 */
public class Trie {
    private class Node {
        private boolean isWord; //判断是否是一个单词

        private HashMap<Character, Node> next;  //指向next节点

        Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new HashMap<>();
        }

        Node() {
            this(false);
        }
    }

    private Node root;

    private int size;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node node = cur.next.get(c);
            if (null == node) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean search(String word) {
        Node node = find(word);
        if (null == node) {
            return false;
        }
        return find(word).isWord;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Node find(String string) {
        Node cur = root;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            Node node = cur.next.get(c);
            if (null == node) {
                return null;
            }
            cur = cur.next.get(c);
        }
        return cur;
    }
}