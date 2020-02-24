package question0430_flatten_a_multilevel_doubly_linked_list;

import java.util.Stack;

/**
 * 栈的应用。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为链表中的节点个数。
 *
 * 执行用时：1ms，击败31.20%。消耗内存：37.7MB，击败42.32%。
 */
public class Solution2 {
    public Node flatten(Node head) {
        if (null == head) {
            return null;
        }
        Node pre = null;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (null != pre) {
                pre.next = cur;
            }
            cur.prev = pre;
            if (null != cur.next) {
                stack.push(cur.next);
            }
            if (null != cur.child) {
                stack.push(cur.child);
                cur.child = null;
            }
            pre = cur;
        }
        return head;
    }
}