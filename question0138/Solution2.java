package question0138;

import java.util.HashMap;
import java.util.Map;

/**
 * 用一个HashMap保存原节点和新节点，以便根据原节点来找到新节点。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n是链表中的节点个数。
 *
 * 执行用时：2ms，击败57.38%。消耗内存：34.4MB，击败66.29%。
 */
public class Solution2 {
    private Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }
        Node cur = head;
        while (null != cur) {
            Node node = new Node();
            node.val = cur.val;
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (null != cur) {
            map.get(cur).next = map.get(cur.next);
            //hashMap.get(cur).next = cur.next; 不能这样写，这样写会导致其next指针指向原节点而不是新节点
            map.get(cur).random = map.get(cur.random);
            //hashMap.get(cur).random = cur.random; 同理，这里也不能这样写
            cur = cur.next;
        }
        return map.get(head);
    }
}
