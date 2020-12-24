package question0460_lfu_cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    private static class Node {
        private int freq;

        private int key;

        private int val;
    }

    private Map<Integer, Node> key2Node = new HashMap<>();

    private Map<Integer, LinkedHashSet<Node>> freq2NodeSet = new HashMap<>();

    private int min;

    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = key2Node.get(key);
        if (null == node) {
            return -1;
        }
        freq2NodeSet.get(node.freq).remove(node);
        freq2NodeSet.computeIfAbsent(node.freq + 1, k -> new LinkedHashSet<>());
        freq2NodeSet.get(node.freq + 1).add(node);
        if (freq2NodeSet.get(node.freq).isEmpty() && min == node.freq) {
            min++;
        }
        node.freq++;
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = key2Node.get(key);
        if (node == null) {
            if (key2Node.size() == capacity) {
                Node removedNode = freq2NodeSet.get(min).iterator().next();
                key2Node.remove(removedNode.key);
                freq2NodeSet.get(min).remove(removedNode);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            newNode.freq = 1;
            min = 1;
            key2Node.put(key, newNode);
            freq2NodeSet.computeIfAbsent(1, k -> new LinkedHashSet<>());
            freq2NodeSet.get(1).add(newNode);
        } else {
            node.val = value;
            freq2NodeSet.get(node.freq).remove(node);
            freq2NodeSet.computeIfAbsent(node.freq + 1, k -> new LinkedHashSet<>());
            freq2NodeSet.get(node.freq + 1).add(node);
            if (freq2NodeSet.get(node.freq).isEmpty() && min == node.freq) {
                min++;
            }
            node.freq++;
        }
    }

}