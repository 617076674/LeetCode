package question1171_remove_zero_sum_consecutive_nodes_from_linked_list;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for (ListNode d = dummyHead; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }
        sum = 0;
        for (ListNode d = dummyHead; d != null; d = d.next) {
            sum += d.val;
            d.next = map.get(sum).next;
        }
        return dummyHead.next;
    }

}