package question0716_max_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 使用线性的数据结构（例如数组和栈）无法在较短的时间复杂度内完成popMax()操作，因此我们可以考虑使用双向链表 + 平衡树，
 * 其中双向链表用来表示栈，平衡树中的每一个节点存储一个键值对，其中“键”表示某个在栈中出现的值，“值”为一个列表，表示这个
 * 值在双向链表中出现的位置，存储方式为指针。平衡树的插入，删除和查找操作都是O(logn)的，而通过平衡树定位到双向链表中的
 * 某个节点后，对该节点进行删除也是O(1)的，因此所有操作的时间复杂度都不会超过O(logn)。
 *
 * 执行用时：24ms，击败96.00%。消耗内存：46.6MB，击败100.00%。
 */
public class MaxStack2 {
    private class Node {    //双向链表的节点
        int val;

        Node prev, next;

        Node(int v) {
            val = v;
        }
    }

    private class DoubleLinkedList {
        Node head, tail;

        DoubleLinkedList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        public Node add(int val) {  //新增节点添加在链表末
            Node x = new Node(val);
            x.next = tail;
            x.prev = tail.prev;
            tail.prev = tail.prev.next = x;
            return x;
        }

        public int pop() {
            return unlink(tail.prev).val;
        }

        public int peek() {
            return tail.prev.val;
        }

        public Node unlink(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
    }

    TreeMap<Integer, List<Node>> map;

    DoubleLinkedList doubleLinkedList;

    public MaxStack2() {
        map = new TreeMap();
        doubleLinkedList = new DoubleLinkedList();
    }

    public void push(int x) {
        Node node = doubleLinkedList.add(x);
        if(!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(node);
    }

    public int pop() {
        int val = doubleLinkedList.pop();
        List<Node> list = map.get(val);
        list.remove(list.size() - 1);
        if (list.isEmpty()) {
            map.remove(val);
        }
        return val;
    }

    public int top() {
        return doubleLinkedList.peek();
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = peekMax();
        List<Node> list = map.get(max);
        Node node = list.remove(list.size() - 1);
        doubleLinkedList.unlink(node);
        if (list.isEmpty()) {
            map.remove(max);
        }
        return max;
    }
}