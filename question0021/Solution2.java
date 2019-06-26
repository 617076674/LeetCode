package question0021;

/**
 * 递归实现。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为链表l1和链表l2中的结点总数。
 *
 * 执行用时：2ms，击败95.09%。消耗内存：35.8MB，击败87.73%。
 */
public class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }
}
