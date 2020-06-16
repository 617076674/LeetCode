package question0847_shortest_path_visiting_all_nodes;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 时间复杂度和空间复杂度均是 O(n * (2 ^ n))，其中 n 为节点个数。
 *
 * 执行用时：9ms，击败76.47%。消耗内存：39.4MB，击败50.00%。
 */
public class Solution2 {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[1 << n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], n * n);
        }
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 0;
        }
        for (int state1 = 0; state1 < 1 << n; state1++) {
            boolean repeat = true;
            while (repeat) {
                repeat = false;
                for (int head = 0; head < n; ++head) {
                    for (int next : graph[head]) {
                        int state2 = state1 | (1 << next);
                        if (dp[state1][head] + 1 < dp[state2][next]) {
                            dp[state2][next] = dp[state1][head] + 1;
                            // 同样的已访问节点集合，最后访问的那个节点有变化。这个状态变化可能会有更短路径出现，需要更新一遍。
                            if (state1 == state2) {
                                repeat = true;
                            }
                        }
                    }
                }
            }
        }
        int result = n * n;
        for (int begin : dp[(1 << n) - 1]) {
            result = Math.min(begin, result);
        }
        return result;
    }
}