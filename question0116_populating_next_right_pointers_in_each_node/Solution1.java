package question0116_populating_next_right_pointers_in_each_node;

import java.util.LinkedList;

public class Solution1 {

    public Node connect(Node root) {
        dfs(root, 0, new LinkedList<>());
        return root;
    }

    private void dfs(Node root, int level, LinkedList<Node> linkedList) {
        if (null == root) {
            return;
        }
        if (linkedList.size() <= level) {
            linkedList.add(root);
        } else {
            Node node = linkedList.remove(level);
            node.next = root;
            linkedList.add(level, root);
        }
        dfs(root.left, level + 1, linkedList);
        dfs(root.right, level + 1, linkedList);
    }

}