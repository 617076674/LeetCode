package question0002_add_two_numbers;

/**
 * 递归实现。
 *
 * 时间复杂度和空间复杂度均是O(n1 + n2)，其中n1为链表l1的长度，n2位链表l2的长度。
 *
 * 执行用时：2ms，击败99.95%。消耗内存：39.9MB，击败95.88%。
 */
public class Solution3 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int flag) {
        if (l1 == null && l2 == null) {
            if (flag == 0) {
                return null;
            }
            return new ListNode(1);
        } else if (l1 == null) {
            if (flag == 0) {
                return l2;
            }
            int num = l2.val + flag;
            if (num >= 10) {
                num -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            l2.val = num;
            l2.next = addTwoNumbers(l1, l2.next, flag);
            return l2;
        } else if (l2 == null) {
            if (flag == 0) {
                return l1;
            }
            int num = l1.val + flag;
            if (num >= 10) {
                num -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            l1.val = num;
            l1.next = addTwoNumbers(l1.next, l2, flag);
            return l1;
        }
        int num = l1.val + l2.val + flag;
        if (num >= 10) {
            num -= 10;
            flag = 1;
        } else {
            flag = 0;
        }
        l1.val = num;
        l1.next = addTwoNumbers(l1.next, l2.next, flag);
        return l1;
    }
}