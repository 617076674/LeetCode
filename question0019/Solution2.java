package question0019;

/**
 * 一趟扫描，双指针，让一个指针先走n步。
 *
 * 时间复杂度是O(m)，其中m为链表的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败90.99%。消耗内存：35.4MB，击败83.59%。
 */
public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead, cur2 = dummyHead;
        while (n > 0) {
            cur2 = cur2.next;
            n--;
        }
        while (cur2.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur1.next = cur1.next.next;
        return dummyHead.next;
    }
}
