package question_palindrome_linked_list_lcci;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 *
 * 时间复杂度是O(n)，其中n为链表中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：42.3MB，击败100.00%。
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead, cur2 = dummyHead;
        while (cur2.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
            if (null == cur2) {
                break;
            }
        }
        ListNode reverseOfLastHalf = reverseList(cur1.next);
        ListNode tmp1 = head, tmp2 = reverseOfLastHalf;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val != tmp2.val) {
                return false;
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode listNode) {
        if (null == listNode || listNode.next == null) {
            return listNode;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = listNode;
        ListNode cur1 = dummyHead.next, cur2 = cur1.next;
        while (cur2 != null) {
            cur1.next = cur2.next;
            cur2.next = dummyHead.next;
            dummyHead.next = cur2;
            cur2 = cur1.next;
        }
        return dummyHead.next;
    }
}