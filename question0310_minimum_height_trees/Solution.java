package question0310_minimum_height_trees;

import java.util.*;

/**
 * 剥洋葱法。
 *
 * 执行用时：21ms，击败85.52%。消耗内存：40.7MB，击败100.00%。
 */
public class Solution {
    private Map<Integer, List<Integer>> graph = new HashMap<>();    //用邻接矩阵构建图

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);    //如果只有一个节点，显然该节点就是所求的根
        }
        //记录每个节点连接边数的数组
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            addAnEdge(node1, node2);
            addAnEdge(node2, node1);
            degree[node1]++;
            degree[node2]++;
        }
        Queue<Integer> queue = new LinkedList<>();  //叶子节点队列
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        int reserve = n;    //目前还剩余reserve个节点
        while (reserve != 1 && reserve != 2) {
            int qSize = queue.size();
            reserve -= qSize;
            for (int i = 0; i < qSize; i++) {
                int now = queue.poll();
                List<Integer> list = graph.get(now);
                for (int j = 0; j < list.size(); j++) {
                    if (degree[list.get(j)] > 0) {
                        degree[list.get(j)]--;
                    }
                    if (degree[list.get(j)] == 1) {
                        queue.add(list.get(j));
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }

    private void addAnEdge(int node1, int node2) {
        if (graph.containsKey(node1)) {
            graph.get(node1).add(node2);
        } else {
            graph.put(node1, new ArrayList<>());
            graph.get(node1).add(node2);
        }
    }
}