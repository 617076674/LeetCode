package question0092_reverse_linked_list_ii;

/**
 * 问题的关键是要用一趟扫描确定待反转的区域。然后递归地反转链表。
 *
 * 时间复杂度是O(p)，其中p为链表中的结点个数。空间复杂度是O(n - m)，因为反转链表时使用了递归实现。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：34.1MB，击败89.26%。
 */
public class Solution1 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        cur1 = movePoint(cur1, m - 1);  //令cur1指向待反转的链表区域的第一个结点的前一个结点所在的位置
        ListNode cur2 = cur1.next;
        cur2 = movePoint(cur2, n - m);  //令cur2执行待反转的链表区域的最后一个结点位置
        ListNode temp1 = cur1.next, temp2 = cur2.next;
        cur2.next = null;
        cur1.next = reverse(temp1);
        temp1.next = temp2;
        return dummyHead.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode movePoint(ListNode cur, int step) {
        while (step > 0) {
            cur = cur.next;
            step--;
        }
        return cur;
    }

}
