package question429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                Node now = queue.poll();
                list.add(now.val);
                for (Node node : now.children) {
                    queue.add(node);
                }
            }
            result.add(list);
        }
        return result;
    }

}
