package question0025_reverse_nodes_in_k_group;

/**
 * 三指针。
 *
 * 时间复杂度是 O(n)，其中 n 为链表中的节点个数。空间复杂度是 O(1)。
 *
 * 执行用时：2ms，击败59.69%。消耗内存：38.6MB，击败76.24%。
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        if (cur1.next == null || cur1.next.next == null) {
            return head;
        }
        ListNode cur2 = cur1.next, cur3 = cur1;
        while (true) {
            int index = k;
            while (index > 0) {
                cur3 = cur3.next;
                if (cur3 == null) {
                    return dummyHead.next;
                }
                index--;
            }
            ListNode tmp = cur3.next;
            cur3.next = null;
            cur1.next = reverseList(cur2);
            cur2.next = tmp;
            cur1 = cur2;
            cur2 = tmp;
            cur3 = cur1;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head.next;
        while (null != cur) {
            ListNode tmp = cur.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            head.next = tmp;
            cur = tmp;
        }
        return dummyHead.next;
    }
}