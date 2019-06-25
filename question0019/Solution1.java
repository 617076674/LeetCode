package question0019;

/**
 * 两次扫描。第一趟扫描目的是得到链表的总节点个数。第二趟扫描的目的是找到待删除节点的前一个节点。
 *
 * 时间复杂度是O(m)，其中m为链表的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败90.99%。消耗内存：35.2MB，击败86.24%。
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        while (cur1.next != null) {
            count++;
            cur1 = cur1.next;
        }
        int preDelIndex = count - n, index = 0;
        ListNode cur2 = dummyHead;
        while (index != preDelIndex) {
            index++;
            cur2 = cur2.next;
        }
        cur2.next = cur2.next.next;
        return dummyHead.next;
    }
}
