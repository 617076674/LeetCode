package question0138;

/**
 * 分为三个过程：
 * （1）对链表中的每一个节点，复制一个添加到原节点的后面。
 * （2）为新复制的链表设置random指针的指向。
 * （3）分离出原链表和新链表。
 *
 * 时间复杂度是O(n)，其中n是链表中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败57.28%。消耗内存：36.6MB，击败12.96%。
 */
public class Solution3 {
    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }
        doubleRandomList(head);
        setRandomPoint(head);
        return seperateList(head);
    }

    /**
     * 对链表中的每一个节点，复制一个添加到原节点的后面。
     * 比如原来链表是 1 -> 2，复制后就成为 1 -> 1' -> 2 -> 2'
     */
    private Node doubleRandomList(Node head) {
        Node cur = head;
        while (cur != null) {
            Node node = new Node(), tmp = cur.next;
            node.val = cur.val;
            cur.next = node;
            node.next = tmp;
            cur = tmp;
        }
        return head;
    }

    /**
     * 为新复制的链表设置random指针的指向。
     */
    private Node setRandomPoint(Node head) {
        Node cur1 = head, cur2 = cur1.next;
        while (true) {
            //对cur1.random节点做非null值判断
            if (cur1.random != null) {
                cur2.random = cur1.random.next;
            }
            cur1 = cur2.next;
            if (cur1 == null) {
                break;
            }
            cur2 = cur1.next;
        }
        return head;
    }

    /**
     * 分离出原链表和新链表
     */
    private Node seperateList(Node head) {
        Node node = head;
        Node cloneHead = head.next;
        while(node.next != null){
            Node temp = node.next;  //防止node.next节点丢失，用temp变量先记录下来
            node.next = node.next.next;
            node = temp;
        }
        return cloneHead;
    }
}
