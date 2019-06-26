package question0206;

/**
 * 递归地反转链表。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为链表中的结点个数。
 *
 * 执行用时：1ms，击败77.77%。消耗内存：35.9MB，击败56.08%。
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        //对空链表和链表中只有一个结点的情况做特殊处理
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        //当前第二个结点的下一个节点显然就是当前结点
        head.next.next = head;
        //当前结点成为链表的尾结点
        head.next = null;
        return newHead;
    }
}

