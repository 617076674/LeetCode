package question_partition_list_lcci;

/**
 * https://leetcode-cn.com/problems/partition-list-lcci/
 *
 * 时间复杂度是O(n)，其中n为链表中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.6MB，击败100.00%。
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val < x) {
                ListNode lessNode = cur.next;
                cur.next = lessNode.next;
                lessNode.next = dummyHead.next;
                dummyHead.next = lessNode;
                if (cur == dummyHead) {
                    cur = cur.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}