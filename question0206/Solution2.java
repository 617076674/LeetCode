package question0206;

/**
 * 循环实现。
 *
 * 时间复杂度是O(n)，其中n为链表中的结点个数。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败77.77%。消耗内存：36.3MB，击败55.80%。
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        //对空链表和链表中只有一个结点的情况做特殊处理
        if(dummyHead.next == null || dummyHead.next.next == null) {
            return head;
        }
        ListNode cur1 = dummyHead.next, cur2 = cur1.next;
        while(cur2 != null) {
            cur1.next = cur2.next;
            ListNode temp = dummyHead.next;
            dummyHead.next = cur2;
            cur2.next = temp;
            cur2 = cur1.next;
        }
        return dummyHead.next;
    }
}

