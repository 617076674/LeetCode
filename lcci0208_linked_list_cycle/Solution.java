package lcci0208_linked_list_cycle;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-lcci/
 *
 * 时间复杂度是O(n)，其中n为链表中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.7MB，击败100.00%。
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode cur1 = head, cur2 = head;
        do {
            if (cur2 == null || cur2.next == null) {
                return null;
            }
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        } while (cur1 != cur2);
        cur1 = head;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}