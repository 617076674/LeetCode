package question0426_convert_binary_search_tree_to_sorted_doubly_linked_list;

public class Node {
    public int val;

    public Node left;

    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}