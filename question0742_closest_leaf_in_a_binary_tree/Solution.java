package question0742_closest_leaf_in_a_binary_tree;

import java.util.*;

/**
 * 将树转化为图，再广搜。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：7ms，击败40.82%。消耗内存：39.6MB，击败100.00%。
 */
public class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        if (root.left == null && root.right == null) {
            return k;
        }
        List<Integer>[] graph = new List[1001];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(root);
        boolean[] isLeaf = new boolean[1001];
        while (!queue1.isEmpty()) {
            TreeNode now = queue1.poll();
            if (now.left == null && now.right == null) {
                isLeaf[now.val] = true;
            }
            if (now.left != null) {
                graph[now.val].add(now.left.val);
                graph[now.left.val].add(now.val);
                queue1.add(now.left);
            }
            if (now.right != null) {
                graph[now.val].add(now.right.val);
                graph[now.right.val].add(now.val);
                queue1.add(now.right);
            }
        }
        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(k);
        boolean[] visited = new boolean[1001];
        while (!queue2.isEmpty()) {
            int qSize = queue2.size();
            for (int i = 0; i < qSize; i++) {
                int now = queue2.poll();
                visited[now] = true;
                if (isLeaf[now]) {
                    return now;
                }
                for (int j = 0; j < graph[now].size(); j++) {
                    if (!visited[graph[now].get(j)]) {
                        queue2.add(graph[now].get(j));
                    }
                }
            }
        }
        return -1;
    }
}