package question0160_intersection_of_two_linked_lists;

import java.util.Stack;

/**
 * @author qianyihui
 * @date 2019-07-07
 *
 * 分别把两个链表的节点放入两个栈里，这样两个链表的尾节点就位于这两个栈的栈顶。接下来比较两个栈顶的节点是否相同。如果相同，则把栈顶弹出接着比较
 * 下一个栈顶，直到找到最后一个相同的节点。
 *
 * 时间复杂度和空间复杂度均是O(m + n)，其中m为链表headA的长度，n为链表headBand的长度。
 *
 * 执行用时：8ms，击败14.25%。消耗内存：49.3MB，击败5.05%。
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        ListNode curA = headA;
        while (null != curA) {
            stackA.push(curA);
            curA = curA.next;
        }
        Stack<ListNode> stackB = new Stack<>();
        ListNode curB = headB;
        while (null != curB) {
            stackB.push(curB);
            curB = curB.next;
        }
        if (stackA.isEmpty() || stackB.isEmpty()) {
            return null;
        }
        ListNode lastSame = stackA.pop();
        if (lastSame != stackB.pop()) {
            return null;
        }
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode node = stackA.pop();
            if (node != stackB.pop()) {
                return lastSame;
            }
            lastSame = node;
        }
        return lastSame;
    }
}
