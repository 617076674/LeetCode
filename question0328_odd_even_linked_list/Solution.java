package question0328_odd_even_linked_list;

/**
 * 时间复杂度是 O(n)，其中 n 为链表中的节点个数。空间复杂度是 O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：38.2MB，击败83.12%。
 */
public class Solution {

    public ListNode oddEvenList(ListNode head) {
       ListNode oddDummyHead = new ListNode(-1), evenDummyHead = new ListNode(-1);
       ListNode oddCur = oddDummyHead, evenCur = evenDummyHead, cur = head;
       while (cur != null) {
           oddCur.next = cur;
           oddCur = oddCur.next;
           cur = cur.next;
           if (cur == null) {
               evenCur.next = null;
               break;
           }
           evenCur.next = cur;
           evenCur = evenCur.next;
           cur = cur.next;
           if (cur == null) {
               oddCur.next = null;
           }
       }
       oddCur.next = evenDummyHead.next;
       return oddDummyHead.next;
    }

}