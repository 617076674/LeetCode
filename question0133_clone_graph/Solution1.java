package question0133_clone_graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 深搜。
 *
 * 时间复杂度和空间复杂度均时候 O(n)，其中 n 为图中的节点个数。
 *
 * 执行用时：46ms，击败5.98%。消耗内存：40.2MB，击败11.24%。
 */
public class Solution1 {
    private Map<Integer, Node> map = new HashMap<>();    //记录已克隆的节点

    public Node cloneGraph(Node node) {
        if (null == node) {
            return null;
        }
        Node cloned = map.get(node.val);
        if (null != cloned) {
            return cloned;
        }
        cloned = new Node(node.val);
        map.put(cloned.val, cloned);
        for (Node neighbor : node.neighbors) {
            cloned.neighbors.add(cloneGraph(neighbor));
        }
        return cloned;
    }
}