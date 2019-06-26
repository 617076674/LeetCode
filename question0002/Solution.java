package question0002;

/**
 * 链表的操作，多设指针。
 * <p>
 * 时间复杂度是O(n1 + n2)，其中n1为链表l1的长度，n2位链表l2的长度。空间复杂度是O(1)。
 * <p>
 * 执行用时：10ms，击败80.37%。消耗内存：44.7MB，击败84.76%。
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2;
        int flag = 0;
        while (true) {
            cur1.val += cur2.val + flag;
            if (cur1.val >= 10) {
                cur1.val -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            if (cur1.next == null || cur2.next == null) {
                break;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if (cur1.next == null && cur2.next == null && flag == 1) {
            cur1.next = new ListNode(flag);
        } else if (cur1.next == null && cur2.next != null) {
            //we are to return l1 at last, so we need to make cur1.next refer to cur2.next
            cur1.next = cur2.next;
            cur1.next.val = flag + cur2.next.val;
            ListNode cur = cur1.next;
            while (cur.val >= 10) {
                cur.val -= 10;
                if (cur.next == null) {
                    cur.next = new ListNode(1);
                } else {
                    cur.next.val += 1;
                    cur = cur.next;
                }
            }
        } else if (cur1.next != null) {
            cur1.next.val += flag;
            ListNode cur = cur1.next;
            while (cur.val >= 10) {
                cur.val -= 10;
                if (cur.next == null) {
                    cur.next = new ListNode(1);
                } else {
                    cur.next.val += 1;
                    cur = cur.next;
                }
            }
        }
        return l1;
    }
}
