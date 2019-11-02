package question0677_map_sum_pairs;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典树。
 *
 * 执行用时：64ms，击败78.93%。消耗内存：35.7MB，击败90.59%。
 */
public class MapSum {
    private class Node {
        private int val;

        private Map<Character, Node> next;

        Node() {
            next = new HashMap<>();
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }
    
    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (null == cur.next.get(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.val = val;
    }
    
    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (null == cur.next.get(c)) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        int sum = node.val;
        for(Character c : node.next.keySet()) {
            sum += sum(node.next.get(c));
        }
        return sum;
    }
}