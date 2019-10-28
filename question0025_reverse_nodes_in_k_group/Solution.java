package question0025_reverse_nodes_in_k_group;

/**
 * 三指针。
 *
 * 时间复杂度是O(n)，其中n为链表中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败59.69%。消耗内存：38.6MB，击败76.24%。
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        //如果链表中只有0个或1个节点，无需翻转，直接返回
        if (cur1.next == null || cur1.next.next == null) {
            return head;
        }
        ListNode cur2 = cur1.next, cur3 = cur1;
        while (true) {
            int index = k;
            while (index > 0) {
                cur3 = cur3.next;
                //如果链表中剩余的节点小于k个，无需反转，直接返回
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

    /**
     * 反转链表的函数
     */
    private ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        if (cur1.next == null || cur1.next.next == null) {
            return head;
        }
        ListNode cur2 = cur1.next, cur3 = cur2.next;
        while (cur3 != null) {
            cur2.next = cur3.next;
            ListNode tmp = cur1.next;
            cur1.next = cur3;
            cur3.next = tmp;
            cur3 = cur2.next;
        }
        return dummyHead.next;
    }
}