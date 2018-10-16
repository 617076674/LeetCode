package question086;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83021650
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        if(null == head || null == head.next){
            return head;
        }
        ListNode lessNode = new ListNode(-1);
        ListNode greaterNode = new ListNode(-1);
        ListNode cur = head;
        ListNode cur1 = lessNode;
        ListNode cur2 = greaterNode;
        while(null != cur){
            ListNode temp = new ListNode(cur.val);
            if(cur.val < x){
                cur1.next = temp;
                cur1 = cur1.next;
            }else{
                cur2.next = temp;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur1.next = greaterNode.next;
        return lessNode.next;
    }
}
