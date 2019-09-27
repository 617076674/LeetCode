package question0707_design_linked_list;

/**
 * 增加虚拟头节点方便操作。
 *
 * 执行用时：70ms，击败97.07%。消耗内存：45MB，击败86.60%。
 */
public class MyLinkedList {
    private class ListNode {
        int val;

        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode dummyHead;

    private int count;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummyHead = new ListNode(-1);
        count = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        ListNode cur = dummyHead;
        while (index-- >= 0) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;
        count++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        count++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == count) {
            addAtTail(val);
        } else if (index < count) {
            ListNode cur = dummyHead;
            while (index-- > 0) {
                cur = cur.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = cur.next;
            cur.next = newNode;
            count++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= count) {
            return;
        }
        ListNode cur = dummyHead;
        while (index-- > 0) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        count--;
    }
}