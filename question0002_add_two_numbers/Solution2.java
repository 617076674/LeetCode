package question0002_add_two_numbers;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * 时间复杂度是O(n1 + n2)，其中n1为链表l1的长度，n2位链表l2的长度。空间复杂度是O(1)。
 *
 * 执行用时：10ms，击败80.37%。消耗内存：44.7MB，击败84.76%。
 */
public class Solution2 {
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
        if (null == cur1.next && null == cur2.next && flag == 1) {  //链表l1和链表l2均遍历结束，且有进位
            cur1.next = new ListNode(flag); //在链表l1末尾添加1
        } else {
            if (null == cur1.next && null != cur2.next) {    //链表l1遍历结束，但是链表l2还没有遍历结束
                cur1.next = cur2.next;  //把链表l2剩余部分添加到链表l1末尾
                cur1.next.val = flag + cur2.next.val;
                ListNode cur = cur1.next;
                while (cur.val >= 10) {
                    cur.val -= 10;
                    if (null == cur.next) {
                        cur.next = new ListNode(1);
                    } else {
                        cur.next.val++;
                        cur = cur.next;
                    }
                }
            } else if (null != cur1.next) { //链表l2遍历结束，但是链表l1还没有遍历结束
                cur1.next.val += flag;
                ListNode cur = cur1.next;
                while (cur.val >= 10) {
                    cur.val -= 10;
                    if (null == cur.next) {
                        cur.next = new ListNode(1);
                    } else {
                        cur.next.val++;
                        cur = cur.next;
                    }
                }
            }
        }
        return l1;
    }
}