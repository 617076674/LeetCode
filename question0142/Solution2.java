package question0142;

/**
 * 快慢双指针遍历链表。慢指针每移动1步，快指针就移动2步。
 * <p>
 * 当快慢指针相遇时，假设慢指针移动了x步，则快指针移动了2x步，那么链表中存在环，且环的长度为2x - x = x。
 * <p>
 * 具体分析请见：https://blog.csdn.net/qq_41231926/article/details/86105434
 * <p>
 * 时间复杂度是O(n)，其中n为链表中环的长度。空间复杂度是O(1)。
 * <p>
 * 执行用时：1ms，击败93.77%。消耗内存：39.7MB，击败47.46%。
 */
public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead, cur2 = dummyHead;
        while (true) {
            if (null == cur2.next || null == cur2.next.next) {
                return null;
            }
            cur1 = cur1.next;
            cur2 = cur2.next.next;
            if (cur1 == cur2) {
                break;
            }
        }
        cur1 = dummyHead;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
