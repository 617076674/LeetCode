package lcci0201_remove_duplicate_node;

/**
 * 哈希表。
 *
 * 时间复杂度是O(n)，其中n为链表的节点个数。空间复杂度是O(20001)。
 *
 * 执行用时：2ms，击败99.00%。消耗内存：42.4MB，击败100.00%。
 */
public class Solution1 {
    public ListNode removeDuplicateNodes(ListNode head) {
        boolean[] exists = new boolean[20001];
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (exists[cur.next.val]) {
                ListNode tmp = cur.next;
                while (tmp != null && exists[tmp.val]) {
                    tmp = tmp.next;
                }
                cur.next = tmp;
            } else {
                exists[cur.next.val] = true;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}