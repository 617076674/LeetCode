package question0142_linked_list_cycle_ii;

import java.util.HashSet;
import java.util.Set;

/**
 * 用一个HashSet记录遍历过的节点。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为链表中的结点数目。
 *
 * 执行用时：18ms，击败13.52%。消耗内存：35.9MB，击败7.16%。
 */
public class Solution1 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (null != cur.next) {
            if (set.contains(cur.next)) {
                return cur.next;
            }
            cur = cur.next;
            set.add(cur);
        }
        return null;
    }
}