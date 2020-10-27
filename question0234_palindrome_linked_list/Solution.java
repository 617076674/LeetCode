package question0234_palindrome_linked_list;

/**
 * 快慢双指针 + 反转链表
 *
 * 时间复杂度是 O(n)，其中 n 为链表中的节点个数。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败99.86%。消耗内存：41.1MB，击败93.28%。
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur2 = dummyHead, cur3 = dummyHead;
        while (cur3 != null && cur3.next != null) {
            cur2 = cur2.next;
            cur3 = cur3.next.next;
        }
        ListNode tmp = cur2.next;
        cur2.next = null;
        ListNode newHead = reverseLinkedList(tmp);
        ListNode cur = head, newCur = newHead;
        while (cur != null && newCur != null) {
            if (cur.val != newCur.val) {
                return false;
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, cur = head, next = cur.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (cur != null) {
                next = cur.next;
            }
        }
        return pre;
    }

}