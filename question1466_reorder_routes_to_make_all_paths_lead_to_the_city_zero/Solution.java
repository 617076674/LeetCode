package question1466_reorder_routes_to_make_all_paths_lead_to_the_city_zero;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int minReorder(int n, int[][] connections) {
        Set<Integer>[] graph1 = new Set[n], graph2 = new Set[n];
        for (int i = 0; i < n; i++) {
            graph1[i] = new HashSet<>();
            graph2[i] = new HashSet<>();
        }
        for (int[] connection : connections) {
            graph1[connection[0]].add(connection[1]);
            graph2[connection[1]].add(connection[0]);
        }
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int now = queue.poll();
                for (int next : graph1[now]) {
                    if (!visited[next]) {
                        result++;
                        queue.add(next);
                        visited[next] = true;
                    }
                }
                for (int next : graph2[now]) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return result;
    }

}