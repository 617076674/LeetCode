package question0369_plus_one_linked_list;

/**
 * 双指针。
 *
 * 对于1234的情况，结果是1235。
 * 对于1239的情况，结果是1240。
 * 对于1293的情况，结果是1294。
 * 对于9的情况，结果是10。
 *
 * 指针cur1遍历整个链表。当cur1的值不是9时，指针cur2跟随cur1，否则cur2保持不动。
 *
 * 遍历结束后，令指针cur2指向的值加1，并将其后的值均置为0即可。
 *
 * 如果cur2没有移动任何一步，说明链表中的值均是9，只需要返回cur2即可；否则，返回head节点。
 *
 * 时间复杂度是O(n)，其中n是链表的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：34.6MB，击败25.00%。
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur1 = dummyHead, cur2 = dummyHead;
        while (null != cur1) {
            if (cur1.val != 9) {
                cur2 = cur1;
            }
            cur1 = cur1.next;
        }
        ListNode cur = cur2;
        cur.val++;
        while (cur.next != null) {
            cur = cur.next;
            cur.val = 0;
        }
        return cur2.next == head ? cur2 : head;
    }
}