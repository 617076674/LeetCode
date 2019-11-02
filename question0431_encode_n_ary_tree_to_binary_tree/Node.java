package question0431_encode_n_ary_tree_to_binary_tree;

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}