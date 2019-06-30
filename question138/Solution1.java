package question138;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n是链表中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：6ms，击败6.55%。消耗内存：34.7MB，击败65.92%。
 */
public class Solution1 {
    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }
        Node newHead = new Node();
        newHead.val = head.val;
        Node cur1 = head.next, cur2 = newHead;
        while (cur1 != null) {
            Node node = new Node();
            node.val = cur1.val;
            cur2.next = node;
            cur2 = node;
            cur1 = cur1.next;
        }
        cur1 = newHead;
        cur2 = head;
        while (cur1 != null) {
            int step = 0;
            Node cur = head;
            while (cur != cur2.random) {
                cur = cur.next;
                step++;
            }
            cur = newHead;
            while (step > 0) {
                cur = cur.next;
                step--;
            }
            cur1.random = cur;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return newHead;
    }
}
