package lcci1625_lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private static class Node {
        Node prev;

        Node next;

        int val;

        int key;
    }

    private Map<Integer, Node> map = new HashMap<>();

    private Node dummyHead = new Node();

    private Node dummyTail = new Node();

    private int capacity;

    public LRUCache(int capacity) {
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (null == node) {
            return -1;
        }
        del(node);
        add(node);
        return node.val;
    }

    private void add(Node node) {
        dummyHead.next.prev = node;
        node.next = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
    }

    private void del(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (null == node) {
            if (map.size() >= capacity) {
                map.remove(dummyTail.prev.key);
                del(dummyTail.prev);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            map.put(key, newNode);
            add(newNode);
        } else {
            node.val = value;
            del(node);
            add(node);
        }
    }

}