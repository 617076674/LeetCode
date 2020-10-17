package question0142_linked_list_cycle_ii;

/**
 * 快慢双指针遍历链表。慢指针每移动1步，快指针就移动2步。
 *
 * 当快慢指针相遇时，假设慢指针移动了x步，则快指针移动了2x步，那么链表中存在环，且环的长度为2x - x = x。
 *
 * 具体分析请见：https://blog.csdn.net/qq_41231926/article/details/86105434
 *
 * 时间复杂度是O(n)，其中n为链表中环的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败93.77%。消耗内存：39.7MB，击败47.46%。
 */
public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur1 = head, cur2 = head;  //这里不能设立虚拟头节点，需要以head为起点
        do {
            if (null == cur2.next || null == cur2.next.next) {
                return null;
            }
            cur1 = cur1.next;   //慢指针cur1一次走一步
            cur2 = cur2.next.next;  //快指针cur2一次走两步
        } while (cur1 != cur2);
        cur1 = head;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}