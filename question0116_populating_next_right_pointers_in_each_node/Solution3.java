package question0116_populating_next_right_pointers_in_each_node;

public class Solution3 {

    public Node connect(Node root) {
        if (null == root) {
            return null;
        }
        Node first = root;
        while (null != first) {
            Node p = first;
            Node cur = null;
            first = p.left;
            while (null != p) {
                if (null != cur) {
                    cur.next = p.left;
                    cur = cur.next;
                } else {
                    cur = p.left;
                }
                if (null != cur) {
                    cur.next = p.right;
                    cur = cur.next;
                }
                p = p.next;
            }
        }
        return root;
    }

}