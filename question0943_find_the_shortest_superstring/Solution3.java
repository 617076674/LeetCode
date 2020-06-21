package question0943_find_the_shortest_superstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示对于数组 A 中的各个字符串，其被选择的状态是 i，即如果 ((i >> k) & 1) == 1，则说明 A[k] 已经被选中，
 * 其最后一个连接上的字符串是 A[j]。
 *
 * 初始化条件：
 * dp[1 << j][j] = A[j].length()。
 *
 * 状态转移方程：
 * dp[i][j] = min(dp[i ^ (1 << j)][k] + map[k][j])。
 *
 * 时间复杂度是 O((n ^ 2) * (2 ^ n))，其中 n 为数组 A 的长度。空间复杂度是 O(n * (2 ^ n))。
 *
 * 执行用时：23ms，击败85.71%。消耗内存：39.7MB，击败100.00%。
 */
public class Solution3 {
    public String shortestSuperstring(String[] A) {
        int n = A.length;
        int[][] map = new int[n][n];  // map[i][j] 表示将字符串 A[j] 拼接在字符串 A[i] 后面的新增长度
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    map[i][j] = A[j].length();
                    for (int k = 1; k < Math.min(A[i].length(), A[j].length()); k++) {
                        if (A[i].substring(A[i].length() - k).equals(A[j].substring(0, k))) {
                            map[i][j] = A[j].length() - k;
                        }
                    }
                }
            }
        }
        int[][] dp = new int[1 << n][n], parent = new int[1 << n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = A[i].length();
        }
        for (int i = 0; i < (1 << n); i++) {
            Arrays.fill(parent[i], -1);
        }

        for (int status = 1; status < (1 << n); status++) {
            for (int j = 0; j < n; j++) {
                if (((status & (1 << j)) != 0)) {
                    for (int k = 0; k < n; k++) {
                        if (k != j && dp[status ^ (1 << j)][k] + map[k][j] < dp[status][j]) {
                            dp[status][j] = dp[status ^ (1 << j)][k] + map[k][j];
                            parent[status][j] = k;
                        }
                    }
                }
            }
        }
        int minLen = Integer.MAX_VALUE, node = -1;
        for (int i = 0; i < n; i++) {
            int tmp = dp[(1 << n) - 1][i];
            if (tmp < minLen) {
                minLen = tmp;
                node = i;
            }
        }
        int status = (1 << n) - 1;
        List<Integer> path = new ArrayList<>();
        while (node != -1) {
            path.add(node);
            int tmp = parent[status][node];
            status ^= 1 << node;
            node = tmp;
        }
        StringBuilder sb = new StringBuilder(A[path.get(path.size() - 1)]);
        for (int i = path.size() - 2; i >= 0; i--) {
            sb.append(A[path.get(i)].substring(A[path.get(i)].length() - map[path.get(i + 1)][path.get(i)]));
        }
        return sb.toString();
    }
}