package question133;

import java.util.HashMap;

public class Solution1 {
    private HashMap<Integer, UndirectedGraphNode> hashMap = new HashMap<>();    //记录已克隆的节点

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (null == node) {
            return null;
        }
        UndirectedGraphNode cloned = hashMap.get(node.label);
        if (null != cloned) {
            return cloned;
        }
        cloned = new UndirectedGraphNode(node.label);
        hashMap.put(cloned.label, cloned);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            cloned.neighbors.add(cloneGraph(neighbor));
        }
        return cloned;
    }
}
