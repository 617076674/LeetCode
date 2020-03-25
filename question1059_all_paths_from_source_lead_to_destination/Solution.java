package question1059_all_paths_from_source_lead_to_destination;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer>[] graph;

    private int[] visited;

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        visited = new int[n];
        return dfs(source, destination);
    }

    public boolean dfs(int now, int destination) {
        if (graph[now].size() == 0) {
            return now == destination;
        }
        visited[now] = 1; //标记v当前路径上
        for (int next : graph[now]) {
            //下一个节点成环或者未访问但是无法到达终点
            if (visited[next] == 1 || (visited[next] == 0 && !dfs(next, destination))) {
                return false;
            }
        }
        visited[now] = -1;    //已访问过
        return true;
    }
}