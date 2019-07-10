package question0146;

import java.util.*;

/**
 * 哈希表加双向链表。
 *
 * 每次新增节点时，往链表头部放入。需要删除时，删除链表尾节点。
 *
 * get()和put()的时间复杂度均是O(1)。空间复杂度是O(n)，其中n为缓存的键数。
 *
 * 执行用时：141ms，击败79.91%。消耗内存：55.7MB，击败96.89%。
 */
class LRUCache1 {
    private class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node dummyHead = new Node();
    private Node dummyTail = new Node();
    private int capacity;
    private int size;
    private HashMap<Integer, Node> hashMap = new HashMap<>();

    //将节点添加到虚拟头节点之后
    private void add(Node node) {
        Node originHead = dummyHead.next;
        dummyHead.next = node;
        node.pre = dummyHead;
        node.next = originHead;
        originHead.pre = node;
    }

    //删除某个节点
    private void del(Node node) {
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        node.pre = null;
        node.next = null;
    }

    public LRUCache1(int capacity) {
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        Node node = hashMap.get(key);
        if (null == node) {
            return -1;
        }
        del(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if (null != node) {
            node.value = value;
            del(node);
            add(node);
        } else {
            if (size < capacity) {
                size++;
            } else {
                //删除链表尾节点
                Node delNode = dummyTail.pre;
                hashMap.remove(delNode.key);
                del(delNode);
            }
            Node newNode = new Node(key, value);
            add(newNode);
            hashMap.put(key, newNode);
        }
    }
}