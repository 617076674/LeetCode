package question0019_remove_nth_node_from_end_of_list;

/**
 * 一趟扫描，双指针，让一个指针先走n步。
 *
 * 时间复杂度是O(m)，其中m为链表的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.80%。消耗内存：35.3MB，击败85.01%。
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