package question0116_populating_next_right_pointers_in_each_node;

public class Solution2 {

    public Node connect(Node root) {
        if (null == root) {
            return null;
        }
        Node pre = root;
        Node cur = pre.left;
        int level = 0;
        while (null != cur) {
            if (cur == pre.left) {
                cur.next = pre.right;
                cur = cur.next;
            } else {
                if (cur == pre.right && null != pre.next) {
                    cur.next = pre.next.left;
                    cur = cur.next;
                    pre = pre.next;
                } else {
                    pre = root;
                    level++;
                    for (int i = 0; i < level; i++) {
                        pre = pre.left;
                    }
                    cur = pre.left;
                }
            }
        }
        return root;
    }

}