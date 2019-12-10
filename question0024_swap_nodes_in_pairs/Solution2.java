package question0024_swap_nodes_in_pairs;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * 递归实现。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为链表的长度。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：35.1MB，击败63.14%。
 */
public class Solution2 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        if (dummyHead.next == null || dummyHead.next.next == null) {    //如果链表中只有0个或者1个节点，无需进行任何交换操作
            return dummyHead.next;
        }
        ListNode cur1 = dummyHead.next, cur2 = cur1.next;
        cur1.next = swapPairs(cur2.next);
        dummyHead.next = cur2;
        cur2.next = cur1;
        return dummyHead.next;
    }
}