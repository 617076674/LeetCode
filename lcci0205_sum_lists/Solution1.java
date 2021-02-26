package lcci0205_sum_lists;

/**
 * 时间复杂度和空间复杂度均是O(n1 + n2)，其中n1为链表l1的长度，n2位链表l2的长度。
 *
 * 执行用时：2ms，击败100.00%。消耗内存：39.7MB，击败100.00%。
 */
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), cur = dummyHead, cur1 = l1, cur2 = l2;
        int flag = 0;   //flag代表进位
        while (null != cur1 || null != cur2) {
            int num1 = cur1 == null ? 0 : cur1.val, num2 = cur2 == null ? 0 : cur2.val, sum = num1 + num2 + flag;
            if (sum >= 10) {
                sum -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (null != cur1) {
                cur1 = cur1.next;
            }
            if (null != cur2) {
                cur2 = cur2.next;
            }
        }
        if (flag != 0) {    //有进位
            cur.next = new ListNode(1); //在新建链表末尾新增一个值1
        }
        return dummyHead.next;
    }
}