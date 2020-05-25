package question0146_lru_cache;

import java.util.*;

/**
 * 哈希表加双向链表。
 *
 * 每次新增节点时，往链表头部放入。需要删除时，删除链表尾节点。
 *
 * get()和put()的时间复杂度均是O(1)。空间复杂度是O(n)，其中n为缓存的键数。
 *
 * 执行用时：20ms，击败66.67%。消耗内存：48.2MB，击败100.00%。
 */
public class LRUCache1 {
    private class Node {
        private int key, value;

        private Node pre, next;

        Node() {}

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node dummyHead = new Node(), dummyTail = new Node();

    private int capacity, size;

    private Map<Integer, Node> map = new HashMap<>();

    public LRUCache1(int capacity) {
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (null == node) {
            return -1;
        }
        updateState(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (null != node) {
            node.value = value;
            updateState(node);
        } else {
            if (size < capacity) {
                size++;
            } else {
                //删除链表尾节点
                Node delNode = dummyTail.pre;
                map.remove(delNode.key);
                del(delNode);
            }
            Node newNode = new Node(key, value);
            add(newNode);
            map.put(key, newNode);
        }
    }

    /**
     * 调整节点的顺序
     */
    private void updateState(Node node) {
        del(node);
        add(node);
    }

    /**
     * 将节点添加到虚拟头节点之后
     */
    private void add(Node node) {
        Node originHead = dummyHead.next;
        dummyHead.next = node;
        node.pre = dummyHead;
        node.next = originHead;
        originHead.pre = node;
    }

    /**
     * 删除某个节点
     */
    private void del(Node node) {
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        node.pre = null;
        node.next = null;
    }
}