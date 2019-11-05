package question0708_insert_into_a_cyclic_sorted_list;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：39.6MB，击败100.00%。
 */
public class Solution {
    public Node insert(Node head, int insertVal) {
        if (null == head) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }
        Node cur = head;
        while (cur.next != head) {
            if (cur.val <= insertVal && insertVal <= cur.next.val) {
                break;  //插入非最值
            } else if (cur.val <= insertVal && cur.next.val <= insertVal &&  cur.val > cur.next.val) {
                break;  //插入一个最大值
            } else if (cur.val > insertVal && cur.next.val > insertVal &&  cur.val > cur.next.val) {
                break;  //插入一个最小值
            }
            cur = cur.next;
        }
        Node inserted = new Node(insertVal, cur.next);
        cur.next = inserted;
        return head;
    }
}