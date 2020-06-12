package question0656_coin_path;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i] 表示从 i 跳到末尾所需的最小花费。
 *
 * 初始化条件：
 * 如果 A[n - 1] != -1，则有 dp[n - 1] = A[n - 1]，其中 n 为数组 A 的长度。
 *
 * 状态转移方程：
 * dp[i] = min(A[i] + dp[i + j]), j ∈ [1, B]。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：5ms，击败92.00%。消耗内存：40.1MB，击败100.00%。
 */
public class Solution2 {
    public List<Integer> cheapestJump(int[] A, int B) {
        int n = A.length;
        long[] dp = new long[n];
        int[] next = new int[n];
        List<Integer> result = new ArrayList<>();
        if (A[n - 1] == -1) {
            return result;
        }
        dp[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= B; j++) {
                if (i + j < n && A[i + j] != -1) {
                    long cost = A[i] + dp[i + j];
                    if (cost < dp[i]) {
                        dp[i] = cost;
                        next[i] = i + j;
                    }
                }
            }
        }
        int i;
        for (i = 0; i < n && next[i] > 0; i = next[i]) {
            result.add(i + 1);
        }
        if (i == n - 1 && A[i] >= 0) {
            result.add(n);
            return result;
        }
        return new ArrayList<>();
    }
}