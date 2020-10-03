package question0117_populating_next_right_pointers_in_each_node_ii;

/**
 * 多设指针。
 *
 * 时间复杂度是 O(n)，其中 n 为树中的节点个数。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败58.38%。消耗内存：38.5MB，击败57.11%。
 */
public class Solution2 {

    public Node connect(Node root) {
        Node first = root;
        while (null != first) {
            Node p = first;
            Node cur = null;
            first = null;
            while (null != p) {
                if (null != p.left) {
                    if (null != cur) {
                        cur.next = p.left;
                        cur = cur.next;
                    } else {
                        cur = p.left;
                        first = p.left;
                    }
                }
                if (null != p.right) {
                    if (null != cur) {
                        cur.next = p.right;
                        cur = cur.next;
                    } else {
                        cur = p.right;
                        first = p.right;
                    }
                }
                p = p.next;
            }
        }
        return root;
    }

}