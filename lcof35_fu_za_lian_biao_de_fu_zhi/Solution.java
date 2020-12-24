package lcof35_fu_za_lian_biao_de_fu_zhi;

public class Solution {

    public Node copyRandomList(Node head) {
        return null == head ? null : getNewRandomList(doubleNode(head));
    }

    private Node doubleNode(Node head) {
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        return head;
    }

    private Node getNewRandomList(Node head) {
        Node cur1 = head, newHead = head.next, cur2 = head.next;
        while (true) {
            cur1.next = cur2.next;
            cur1 = cur1.next;
            if (cur1 == null) {
                break;
            }
            cur2.next = cur1.next;
            cur2 = cur2.next;
        }
        return newHead;
    }

}