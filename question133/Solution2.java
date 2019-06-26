package question133;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    private HashMap<Integer, UndirectedGraphNode> hashMap = new HashMap<>();    //记录已克隆的节点

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (null == node) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        hashMap.put(node.label, new UndirectedGraphNode(node.label));
        UndirectedGraphNode root = hashMap.get(node.label);
        while (!queue.isEmpty()) {
            UndirectedGraphNode now = queue.poll();
            UndirectedGraphNode cloned = hashMap.get(now.label);
            for (UndirectedGraphNode neighbor : now.neighbors) {
                if (!hashMap.containsKey(neighbor.label)) {
                    queue.add(neighbor);
                    hashMap.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                }
                cloned.neighbors.add(hashMap.get(neighbor.label));
            }
        }
        return root;
    }
}
