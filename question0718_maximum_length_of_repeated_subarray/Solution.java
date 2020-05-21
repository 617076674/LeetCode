package question0718_maximum_length_of_repeated_subarray;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示数组 A 中 [0, i - 1] 范围内和数组 B 中 [0, j - 1] 范围内的最长公共后缀的长度。
 *
 * 初始化条件：
 * dp[i][0] = dp[j][0] = 0。
 *
 * 状态转移方程：
 * 当 A[i - 1] == B[j - 1] 时，dp[i][j] = dp[i - 1][j - 1] + 1。
 *
 * 时间复杂度和空间复杂度均是 O(na * nb)，其中 na 为数组 A 的长度，nb 为数组 B 的长度。
 */
public class Solution {
    public int findLength(int[] A, int[] B) {
        // dp[i][j] 表示数组A [0, i - 1]范围内，数组B [0, j - 1]范围内公共的最长子数组的长度
        int[][] dp = new int[A.length + 1][B.length + 1];
        int result = 0;
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < B.length + 1; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        System.out.println(new Solution().findLength(A, B));
    }
}