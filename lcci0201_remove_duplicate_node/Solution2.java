package lcci0201_remove_duplicate_node;

/**
 * 时间复杂度是O(n ^ 2)，其中n为链表的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：386ms，击败13.62%。消耗内存：40.5MB，击败100.00%。
 */
public class Solution2 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            // 判断cur.next是否需要被删除
            ListNode tmp = head;
            boolean exists = false;
            while (tmp != cur.next) {
                if (tmp.val == cur.next.val) {
                    exists = true;
                    break;
                }
                tmp = tmp.next;
            }
            if (exists) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}