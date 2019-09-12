package question0023;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n * m)，其中n为lists数组的长度，m为lists数组中链表总节点个数。空间复杂度是O(1)。
 *
 * 执行用时：398ms，击败12.72%。消耗内存：52MB，击败22.17%。
 */
public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n;
        if (null == lists || (n = lists.length) == 0) {
            return null;
        }
        ListNode[] curs = new ListNode[n];
        for (int i = 0; i < n; i++) {
            curs[i] = lists[i];
        }
        ListNode dummyHead = new ListNode(-1), cur = dummyHead;
        do {
            //index索引的作用是寻找一个非空的链表
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (curs[i] != null) {
                    break;
                }
                index++;
            }
            if (index == n) {
                break;
            }
            int minIndex = index;
            for (int i = index + 1; i < n; i++) {
                if (curs[i] != null && curs[i].val < curs[minIndex].val) {
                    minIndex = i;
                }
            }
            cur.next = curs[minIndex];
            cur = cur.next;
            curs[minIndex] = curs[minIndex].next;
        } while (true);
        return dummyHead.next;
    }
}
