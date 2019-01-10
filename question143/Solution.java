package question143;

public class Solution {
    public void reorderList(ListNode head) {
        //设立虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        //cur1指向链表头节点
        ListNode cur1 = head;
        //cur2，cur3是快慢双指针，cur2移动一步，cur3移动两步
        ListNode cur2 = dummyHead;
        ListNode cur3 = dummyHead;
        while(cur3 != null && cur3.next != null) {
            cur2 = cur2.next;
            cur3 = cur3.next.next;
        }
        cur2 = cur2.next;
        //寻找cur2的父节点preCur2
        ListNode preCur2 = dummyHead;
        while(preCur2.next != cur2) {
            preCur2 = preCur2.next;
        }
        preCur2.next = null;
        //反转后半段链表
        ListNode newHead = reverseLinkedList(cur2);
        ListNode newCur1 = newHead;
        //组合出新链表
        while(cur1 != null && newCur1 != null) {
            ListNode nextCur1 = cur1.next;
            ListNode nextNewCur1 = newCur1.next;
            cur1.next = newCur1;
            newCur1.next = nextCur1;
            newCur1 = nextNewCur1;
            cur1 = nextCur1;
        }
    }

    private ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while(cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if(cur != null) {
                next = cur.next;
            }
        }
        return pre;
    }
}