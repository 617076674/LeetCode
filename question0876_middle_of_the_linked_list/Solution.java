package question0876_middle_of_the_linked_list;

/**
 * 双指针。
 *
 * 时间复杂度是O(n)，其中n为链表中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：34MB，击败55.02%。
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead, cur2 = dummyHead;
        while (true) {
            cur1 = cur1.next;
            cur2 = cur2.next;
            if (cur2 == null) {
                return cur1;
            }
            cur2 = cur2.next;
            if (cur2 == null) {
                return cur1;
            }
        }
    }
}
