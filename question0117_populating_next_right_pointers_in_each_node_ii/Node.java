package question0117_populating_next_right_pointers_in_each_node_ii;

public class Node {

    public int val;

    public Node left;

    public Node right;

    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

}