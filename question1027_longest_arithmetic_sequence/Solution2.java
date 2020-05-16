package question1027_longest_arithmetic_sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 状态定义：
 * dp[i][j] 表示以 A[i], A[j] 结尾的最长等差序列的长度。
 *
 * 初始化条件：
 * dp[i][i + 1] = 2。
 *
 * 状态转移方程：
 * dp[i][j] = max(dp[k][i] + 1), k ∈ [0, i) && A[i] - A[k] = A[j] - A[i]。
 *
 * 时间复杂度是 O(n ^ 3)，其中 n 为数组 A 的长度。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：73ms，击败94.27%。消耗内存：61.4MB，击败33.33%。
 */
public class Solution2 {
    public int longestArithSeqLength(int[] A) {
        if (A.length <= 2) {
            return A.length;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[][] dp = new int[A.length][A.length];
        int result = 2;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                dp[i][j] = 2;
                List<Integer> list = map.get(A[i] * 2 - A[j]);
                if (null != list) {
                    for (int k = 0; k < list.size(); k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[list.get(k)][i] + 1);
                    }
                }
                result = Math.max(result, dp[i][j]);
            }
            if (!map.containsKey(A[i])) {
                map.put(A[i], new ArrayList<>());
            }
            map.get(A[i]).add(i);
        }
        return result;
    }
}