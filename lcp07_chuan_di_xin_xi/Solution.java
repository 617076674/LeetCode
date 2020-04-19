package lcp07_chuan_di_xin_xi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 时间复杂度和空间复杂度均是O(n)。
 *
 * 执行用时：12ms，击败100.00%。消耗内存：49.6MB，击败100.00%。
 */
public class Solution {
    public int numWays(int n, int[][] relation, int k) {
        boolean[][] graph = new boolean[n][n];
        for (int i = 0; i < relation.length; i++) {
            graph[relation[i][0]][relation[i][1]] = true;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int result = 0;
        while (k >= 0 && !queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int now = queue.poll();
                if (now == n - 1 && k == 0) {
                    result++;
                }
                for (int j = 0; j < n; j++) {
                    if (graph[now][j]) {
                        queue.add(j);
                    }
                }
            }
            k--;
        }
        return result;
    }
}