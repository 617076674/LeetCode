package lcci0202_kth_node_from_end_of_list;

/**
 * 双指针。
 *
 * 时间复杂度是O(n)，其中n为链表中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：37.3MB，击败100.00%。
 */
public class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead, cur2 = dummyHead;
        while (k > 0) {
            cur2 = cur2.next;
            k--;
        }
        while (cur2 != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1.val;
    }
}