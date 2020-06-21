package question0943_find_the_shortest_superstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O(n ^ 2) * (2 ^ n))，其中 n 为数组 A 的长度。空间复杂度是 O(n * (2 ^ n))。
 *
 * 执行用时：52ms，击败38.96%。消耗内存：39.8MB，击败100.00%。
 */
public class Solution2 {
    private int[][] map, memo, parent;

    private int n;

    public String shortestSuperstring(String[] A) {
        n = A.length;
        map = new int[n][n];  // map[i][j] 表示将字符串 A[j] 拼接在字符串 A[i] 后面的新增长度
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
        memo = new int[1 << n][n];
        parent = new int[1 << n][n];
        for (int i = 0; i < (1 << n); i++) {
            Arrays.fill(parent[i], -1);
        }
        int minLen = Integer.MAX_VALUE, node = -1;
        for (int i = 0; i < n; i++) {
            int tmp = shortestSuperstring(A, (1 << n) - 1, i);
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

    // 现在访问过的节点组成的状态是 status，上一个访问的节点编号是 last，这种情况下的最短超级串长度
    private int shortestSuperstring(String[] A, int status, int last) {
        if (memo[status][last] != 0) {
            return memo[status][last];
        }
        for (int i = 0; i < n; i++) {
            if (status == (1 << i)) {
                memo[status][last] = A[last].length();
                return A[last].length();
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (((status >> i) & 1) == 1 && i != last) {
                int tmp = shortestSuperstring(A, status ^ (1 << last), i) + map[i][last];
                if (tmp < result) {
                    result = tmp;
                    parent[status][last] = i;
                }
            }
        }
        memo[status][last] = result;
        return result;
    }
}
