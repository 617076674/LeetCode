package question0847_shortest_path_visiting_all_nodes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广搜。
 *
 * 时间复杂度和空间复杂度均是 O(n * (2 ^ n))，其中 n 为节点个数。
 *
 * 执行用时：10ms，击败52.94%。消耗内存：40.3MB，击败50.00%。
 */
public class Solution1 {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] distances = new int[n][1 << n];
        for (int i = 0; i < distances.length; i++) {
            Arrays.fill(distances[i], n * n);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{i, 1 << i});
            distances[i][1 << i] = 0;
        }
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[1] == (1 << n) - 1) {
                return distances[now[0]][now[1]];
            }
            for (int j : graph[now[0]]) {
                int newState = now[1] | (1 << j);
                if (distances[now[0]][now[1]] + 1 < distances[j][newState]) {
                    queue.add(new int[]{j, newState});
                    distances[j][newState] = distances[now[0]][now[1]] + 1;
                }
            }
        }
        return -1;
    }
}