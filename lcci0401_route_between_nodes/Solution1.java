package lcci0401_route_between_nodes;

import java.util.*;

/**
 * 广搜。
 *
 * 执行用时：28ms，击败57.05%。消耗内存：90MB，击败100.00%。
 */
public class Solution1 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (start == target) {
            return true;
        }
        Set<Integer>[] trueGraph = new HashSet[n];
        for (int i = 0; i < graph.length; i++) {
            if (trueGraph[graph[i][0]] == null) {
                trueGraph[graph[i][0]] = new HashSet<>();
            }
            trueGraph[graph[i][0]].add(graph[i][1]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            Set<Integer> set = trueGraph[now];
            if (set != null) {
                for (int next : set) {
                    if (!visited[next]) {
                        if (next == target) {
                            return true;
                        }
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return false;
    }
}