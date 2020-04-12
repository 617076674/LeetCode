package question0460_lfu_cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    private class Node {
        private int key;

        private int value;

        private int freq;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }

    private Map<Integer, Node> key2Node;

    private Map<Integer, LinkedHashSet<Node>> freq2Nodes;

    private int capacity;

    private int min;

    public LFUCache(int capacity) {
        key2Node = new HashMap<>(capacity);
        freq2Nodes = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!key2Node.containsKey(key)) {
            return -1;
        }
        Node node = key2Node.get(key);
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!key2Node.containsKey(key)) {
            if (key2Node.size() == capacity) {
                Node deadNode = removeNode();
                key2Node.remove(deadNode.key);
            }
            Node newNode = new Node(key, value);
            key2Node.put(key, newNode);
            addNode(newNode);
        } else {
            Node node = key2Node.get(key);
            node.value = value;
            freqInc(node);
        }
    }

    private void freqInc(Node node) {
        int freq = node.freq;
        LinkedHashSet<Node> set = freq2Nodes.get(freq);
        set.remove(node);
        if (freq == min && set.isEmpty()) {
            min++;
        }
        node.freq++;
        LinkedHashSet<Node> newSet = freq2Nodes.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freq2Nodes.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    private void addNode(Node node) {
        LinkedHashSet<Node> set = freq2Nodes.get(1);
        if (null == set) {
            set = new LinkedHashSet<>();
            freq2Nodes.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    private Node removeNode() {
        LinkedHashSet<Node> set = freq2Nodes.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }
}