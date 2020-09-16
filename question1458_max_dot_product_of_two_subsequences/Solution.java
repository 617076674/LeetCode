package question1458_max_dot_product_of_two_subsequences;

/**
 * 动态规划。
 *
 * 执行用时：12ms，击败65.45%。消耗内存：39.2MB，击败84.78%。
 */
public class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1][n2];
        dp[0][0] = nums1[0] * nums2[0];
        for (int i = 1; i < n1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], nums1[i] * nums2[0]);
        }
        for (int j = 1; j < n2; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], nums1[0] * nums2[j]);
        }
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]),
                    Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j - 1] + nums1[i] * nums2[j],
                        nums1[i] * nums2[j])));
            }
        }
        return dp[n1 - 1][n2 - 1];
    }
}