package question0082;

/**
 * 链表相关的题，多画图一定能出来。
 *
 * 时间复杂度是O(n)，其中n为链表中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败91.09%。消耗内存：37.1MB，击败56.19%。
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //对链表为空或链表中只有一个节点的情况进行特殊处理
        if(head == null || head.next == null){
            return head;
        }
        //设立虚拟头节点，避免对头节点的特殊处理
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead, cur2 = cur1.next, cur3 = cur2.next;
        while(cur3 != null){
            if(cur2.val != cur3.val){
                cur1 = cur2;
                cur2 = cur3;
                cur3 = cur3.next;
            }else {
                while (cur2.val == cur3.val) {
                    cur3 = cur3.next;
                    //如果该重复节点均在链表末尾
                    if (cur3 == null) {
                        cur1.next = null;
                        return dummyHead.next;
                    }
                }
                //现在cur3的指针指向与cur2所指向的节点值不同的下一个节点
                cur1.next = cur3;
                cur2 = cur3;
                cur3 = cur3.next;
            }
        }
        return dummyHead.next;
    }
}
