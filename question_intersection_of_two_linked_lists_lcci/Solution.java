package question_intersection_of_two_linked_lists_lcci;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 *
 * 分别计算两个链表的长度。让长链表的指针先走链表长度差值的步数。
 *
 * 时间复杂度是O(lenA + lenB)，其中LenA为链表headA的长度，LenB为链表headB的长度。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：42.7MB，击败100.00%。
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = lengthOfListNode(headA), lenB = lengthOfListNode(headB);
        if (lenA > lenB) {
            return getIntersectionNode(headB, headA);
        }
        int gap = lenB - lenA;
        ListNode cur1 = headA, cur2 = headB;
        while (gap > 0) {
            cur2 = cur2.next;
            gap--;
        }
        while (cur1 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

    private int lengthOfListNode(ListNode listNode) {
        int result = 0;
        ListNode cur = listNode;
        while (cur != null) {
            result++;
            cur = cur.next;
        }
        return result;
    }
}