package question1669_merge_in_between_linked_lists;

public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode preAListNode = list1, bListNode = list1;
        int gap = b - a;
        while (--a > 0) {
            preAListNode = preAListNode.next;
            bListNode = bListNode.next;
        }
        while (gap-- >= 0) {
            bListNode = bListNode.next;
        }
        preAListNode.next = list2;
        ListNode end2 = list2;
        while (end2.next != null) {
            end2 = end2.next;
        }
        end2.next = bListNode.next;
        bListNode.next = null;
        return list1;
    }
}