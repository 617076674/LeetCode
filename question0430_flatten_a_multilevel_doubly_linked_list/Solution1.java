package question0430_flatten_a_multilevel_doubly_linked_list;

/**
 * 递归实现。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为链表中的节点个数。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：38MB，击败39.90%。
 */
public class Solution1 {
    public Node flatten(Node head) {
        if (null == head) {
            return null;
        }
        if (null == head.child) {
            Node node = flatten(head.next);
            if (null != node) {
                node.prev = head;
            }
            head.next = node;
            return head;
        }
        Node node1 = head.next, node2 = flatten(head.child);
        node2.prev = head;
        head.next = node2;
        head.child = null;
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        if (null != node1) {
            node1.prev = cur;
        }
        cur.next = node1;
        return head;
    }
}