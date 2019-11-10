package question0002_add_two_numbers;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * 链表的操作，多设指针。把链表l2的值加到链表l1对应节点上
 *
 * 时间复杂度是O(n1 + n2)，其中n1为链表l1的长度，n2位链表l2的长度。空间复杂度是O(1)。
 *
 * 执行用时：10ms，击败80.37%。消耗内存：44.7MB，击败84.76%。
 */
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2;
        int flag = 0;   //flag代表进位
        while (true) {
            cur1.val += cur2.val + flag;
            if (cur1.val >= 10) {
                cur1.val -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            if (null == cur1.next || null == cur2.next) {
                break;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if (null == cur1.next && null == cur2.next && flag == 1) {
            //如果链表l1和链表l2均遍历结束，且有进位，则在链表l1末尾添加1
            cur1.next = new ListNode(flag);
        } else if (null == cur1.next && null != cur2.next) {
            //如果链表l1遍历结束，但是链表l2还没有遍历结束，就把链表l2剩余部分添加到链表l1末尾，注意进位flag的影响
            cur1.next = cur2.next;
            cur1.next.val = flag + cur2.next.val;
            ListNode cur = cur1.next;
            while (cur.val >= 10) {
                cur.val -= 10;
                if (null == cur.next) {
                    cur.next = new ListNode(1);
                } else {
                    cur.next.val += 1;
                    cur = cur.next;
                }
            }
        } else if (null != cur1.next) {
            //如果链表l2遍历结束，但是链表l1还没有遍历结束，就把链表l1剩余部分添加到链表2末尾，注意进位flag的影响
            cur1.next.val += flag;
            ListNode cur = cur1.next;
            while (cur.val >= 10) {
                cur.val -= 10;
                if (null == cur.next) {
                    cur.next = new ListNode(1);
                } else {
                    cur.next.val += 1;
                    cur = cur.next;
                }
            }
        }
        return l1;
    }
}