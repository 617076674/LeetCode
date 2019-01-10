package question141;

import java.util.HashSet;

public class Solution1 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while(null != cur.next){
            if(hashSet.contains(cur.next)){
                return true;
            }
            cur = cur.next;
            hashSet.add(cur);
        }
        return false;
    }
}
