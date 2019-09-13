package question0024;

/**
 * 三指针。
 *
 * 时间复杂度是O(n)，其中n为链表的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：35.1MB，击败63.60%。
 */
public class Solution1 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        //如果链表中只有0个或者1个节点，无需进行任何交换操作
        if (cur1.next == null || cur1.next.next == null) {
            return dummyHead.next;
        }
        ListNode cur2 = cur1.next, cur3 = cur2.next;
        while (true) {
            cur2.next = cur3.next;
            cur1.next = cur3;
            cur3.next = cur2;
            cur1 = cur2;
            if (cur1.next == null || cur1.next.next == null) {
                return dummyHead.next;
            }
            cur2 = cur1.next;
            cur3 = cur2.next;
        }
    }
}
