package question0873;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j]:以A[i]、A[j]结尾的最长斐波那契子序列的长度
 *
 * 状态转移：
 * dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1)，其中k满足A[k] + A[i] == A[j]。
 *
 * 即对数组A中的每个[1, n - 1]范围内的元素i，在寻找[0, i - 1]范围内寻找和为A[i]的两个不同数。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为数组A的长度。
 *
 * 执行用时：67ms，击败91.35%。消耗内存：70.8MB，击败30.95%。
 */
public class Solution2 {
    public int lenLongestFibSubseq(int[] A) {
        int n;
        if (null == A || (n = A.length) == 0) {
            return 0;
        }
        int[][] dp = new int[n][n]; //dp[i][j]表示以A[i]、A[j]结尾的最长斐波那契子序列的长度
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2);  //将以A[i]、A[j]结尾的最长斐波那契子序列的长度初始化为2
        }
        int result = 0;
        for (int i = 1; i < n; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                int sum = A[left] + A[right];
                if (sum == A[i]) {
                    dp[right][i] = Math.max(dp[right][i], dp[left][right] + 1);
                    result = Math.max(result, dp[right][i]);
                    left++;
                    right--;
                } else if (sum < A[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result >= 3 ? result : 0;
    }
}
