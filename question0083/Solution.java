package question0083;

/**
 * 与question0082同样的思路。
 *
 * 时间复杂度是O(n)，其中n为链表中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败84.85%。消耗内存：37.2MB，击败51.54%。
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(null == head || null == head.next){
            return head;
        }
        ListNode cur1 = head, cur2 = head.next;
        while(null != cur2){
            if(cur1.val != cur2.val){
                cur1 = cur2;
                cur2 = cur2.next;
            }else{
                while(cur1.val == cur2.val){
                    cur2 = cur2.next;
                    if(null == cur2){
                        cur1.next = null;
                        return head;
                    }
                }
                cur1.next = cur2;
                cur1 = cur2;
                cur2 = cur2.next;
            }
        }
        return head;
    }
}
