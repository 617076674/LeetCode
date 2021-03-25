package question0092_reverse_linked_list_ii;

/**
 * 问题的关键是要用一趟扫描确定待反转的区域。然后非递归地反转链表。
 *
 * 时间复杂度是O(p)，其中p为链表中的结点个数。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：34.1MB，击败89.26%。
 */
public class Solution2 {

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
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        if (dummyHead.next == null || dummyHead.next.next == null) {    //对空链表和链表中只有一个结点的情况做特殊处理
            return head;
        }
        ListNode cur1 = dummyHead.next, cur2 = cur1.next;
        while (cur2 != null) {
            cur1.next = cur2.next;
            ListNode tmp = dummyHead.next;
            dummyHead.next = cur2;
            cur2.next = tmp;
            cur2 = cur1.next;
        }
        return dummyHead.next;
    }

    private ListNode movePoint(ListNode cur, int step) {
        while (step > 0) {
            cur = cur.next;
            step--;
        }
        return cur;
    }

}
