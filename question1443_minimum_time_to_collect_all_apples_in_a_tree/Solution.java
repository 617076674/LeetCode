package question1443_minimum_time_to_collect_all_apples_in_a_tree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 执行用时：76ms，击败23.47%。消耗内存：81.4MB，击败51.82%。
 */
public class Solution {

    private Set<Integer>[] graph;

    private boolean[] visited;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        graph = new Set[n];
        visited = new boolean[n];
        for (int[] edge : edges) {
            if (graph[edge[0]] == null) {
                graph[edge[0]] = new HashSet();
            }
            if (graph[edge[1]] == null) {
                graph[edge[1]] = new HashSet();
            }
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return minTime(0, hasApple);
    }

    private int minTime(int now, List<Boolean> hasApple) {
        int result = 0;
        visited[now] = true;
        for (int child : graph[now]) {
            if (!visited[child]) {
                int cost = minTime(child, hasApple);
                if (cost > 0 || hasApple.get(child)) {
                    result += 2 + cost;
                }
            }
        }
        return result;
    }

}