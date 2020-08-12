package question0133_clone_graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 广搜。
 *
 * 时间复杂度和空间复杂度均时候 O(n)，其中 n 为图中的节点个数。
 *
 * 执行用时：37ms，击败53.27%。消耗内存：40.1MB，击败32.54%。
 */
public class Solution2 {
    public Node cloneGraph(Node node) {
        if (null == node) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node.val, new Node(node.val));
        Node root = map.get(node.val);
        while (!queue.isEmpty()) {
            Node now = queue.poll(), cloned = map.get(now.val);
            for (Node neighbor : now.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    queue.add(neighbor);
                    map.put(neighbor.val, new Node(neighbor.val));
                }
                cloned.neighbors.add(map.get(neighbor.val));
            }
        }
        return root;
    }
}