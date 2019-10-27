package question0019_remove_nth_node_from_end_of_list;

/**
 * 两次扫描。第一趟扫描目的是得到链表的总节点个数。第二趟扫描的目的是找到待删除节点的前一个节点。
 *
 * 时间复杂度是O(m)，其中m为链表的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.80%。消耗内存：35.2MB，击败86.24%。
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;  //记录链表中的节点总数
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (null != cur.next) {
            count++;
            cur = cur.next;
        }
        int preDelIndex = count - n;
        cur = dummyHead;
        while (0 != preDelIndex) {
            cur = cur.next;
            preDelIndex--;
        }
        cur.next = cur.next.next;
        return dummyHead.next;
    }
}
