package question0141_linked_list_cycle;

/**
 * 快慢双指针遍历链表。一旦快指针追上了慢指针，说明有环；否则，无环。
 *
 * 时间复杂度是O(n)，其中n为链表中环的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败93.77%。消耗内存：39.7MB，击败47.46%。
 */
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead, cur2 = dummyHead;
        while (true) {
            if (null == cur2.next || null == cur2.next.next) {
                return false;
            }
            cur1 = cur1.next;   //慢指针cur1一次走一步
            cur2 = cur2.next.next;  //快指针cur2一次走两步
            if (cur1 == cur2) {
                return true;
            }
        }
    }
}