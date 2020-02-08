package question1290_convert_binary_number_in_a_linked_list_to_integer;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：34.2MB，击败61.46%。
 */
public class Solution {
    public int getDecimalValue(ListNode head) {
        int num = 0;
        ListNode cur = head;
        while (null != cur) {
            num = (num << 1) + cur.val;
            cur = cur.next;
        }
        return num;
    }
}