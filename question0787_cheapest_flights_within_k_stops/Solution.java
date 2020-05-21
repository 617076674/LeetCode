package question0787_cheapest_flights_within_k_stops;

/**
 * 深搜。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：110ms，击败10.34%。消耗内存：39.7MB，击败50.00%。
 */
public class Solution {
    private boolean[] visited;

    private int minCost = Integer.MAX_VALUE;

    private int[][] graph;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }
        visited = new boolean[n];
        dfs(src, 0, 0, dst, K + 1);
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    private void dfs(int now, int cost, int step, int dst, int K) {
        if (step > K || cost > minCost) {
            return;
        }
        if (dst == now) {
            minCost = Math.min(minCost, cost);
            return;
        }
        for (int i = 0; i < graph[now].length; i++) {
            if (graph[now][i] != 0) {
                dfs(i, cost + graph[now][i], step + 1, dst, K);
            }
        }
    }
}