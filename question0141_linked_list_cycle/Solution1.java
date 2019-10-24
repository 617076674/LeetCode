package question0141_linked_list_cycle;

import java.util.HashSet;
import java.util.Set;

/**
 * 用一个HashSet记录遍历过的节点，若出现重复，则说明有环。否则，无环。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为链表中的结点数目。
 *
 * 执行用时：15ms，击败9.05%。消耗内存：41.3MB，击败8.17%。
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (null != cur.next) {
            if (set.contains(cur.next)) {
                return true;
            }
            cur = cur.next;
            set.add(cur);
        }
        return false;
    }
}
