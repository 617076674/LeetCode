package question0708_insert_into_a_cyclic_sorted_list;

public class Node {
    public int val;

    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
}