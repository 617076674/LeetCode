package question0445_add_two_numbers_ii;

import java.util.Stack;

/**
 * 栈的应用。
 *
 * 时间复杂度和空间复杂度均是O(n1 + n2)，其中n1为链表l1中的节点个数，n2为链表l2中的节点个数。
 *
 * 执行用时：5ms，击败59.57%。消耗内存：40.1MB，击败95.83%。
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = pushListNodeIntoStack(l1), stack2 = pushListNodeIntoStack(l2);
        int flag = 0;
        ListNode cur = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num;
            if (stack1.isEmpty()) {
                num = flag + stack2.pop();
            } else if (stack2.isEmpty()) {
                num = flag + stack1.pop();
            } else {
                num = flag + stack1.pop() + stack2.pop();
            }
            if (num >= 10) {
                num -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            cur = addListNode(new ListNode(num), cur);
        }
        if (flag == 1) {
            return addListNode(new ListNode(1), cur);
        }
        return cur;
    }

    private ListNode addListNode(ListNode newListNode, ListNode originListNode) {
        newListNode.next = originListNode;
        return newListNode;
    }

    private Stack<Integer> pushListNodeIntoStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = listNode;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        return stack;
    }
}