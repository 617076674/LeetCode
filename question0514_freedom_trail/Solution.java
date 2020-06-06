package question0514_freedom_trail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是是 O(m * n)，其中 m 为字符串 ring 的长度，n 为字符串 key 的长度。
 *
 * 执行用时：33ms，击败30.30%。消耗内存：40.2MB，击败100.00%。
 */
public class Solution {
    private int[][] memo;

    private int m, n;

    private Map<Character, List<Integer>> map = new HashMap<>();

    public int findRotateSteps(String ring, String key) {
        m = ring.length();
        n = key.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            char c = ring.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        return findRotateSteps(ring, 0, key, 0);
    }

    private int findRotateSteps(String ring, int point, String key, int index) {
        if (index == n) {
            return 0;
        }
        if (memo[point][index] != 0) {
            return memo[point][index];
        }
        int result = Integer.MAX_VALUE;
        for (int next : map.get(key.charAt(index))) {
            if (next == point) {
                result = Math.min(result, 1 + findRotateSteps(ring, next, key, index + 1));
            } else if (next > point) {
                result = Math.min(result, 1 + Math.min(next - point, m + point - next) + findRotateSteps(ring, next, key, index + 1));
            } else {
                result = Math.min(result, Math.min(point - next, m + next - point) + 1 + findRotateSteps(ring, next, key, index + 1));
            }
        }
        memo[point][index] = result;
        return result;
    }
}