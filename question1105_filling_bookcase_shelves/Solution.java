package question1105_filling_bookcase_shelves;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i] 表示安放第 [0, i] 本书的最小高度。
 *
 * 初始化条件：
 * dp[0] = books[0][1]。
 *
 * 状态转移方程：
 * （1）将第 i 本书单独放置在新的一层：dp[i] = dp[i - 1] + books[i][1]。
 * （2）将第 j, j ∈ [i - 1, 0] 本书放置在和第 i 本书同一层：dp[i] = dp[j - 1] + max(books[j][1])。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为 books 数组的长度。空间复杂度是 O(n)。
 *
 * 执行用时：1ms，击败78.68%。消耗内存：38.9MB，击败100.00%。
 */
public class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n];
        dp[0] = books[0][1];
        for (int i = 1; i < n; i++) {
            int height = books[i][1], weight = books[i][0];
            dp[i] = dp[i - 1] + books[i][1];
            for (int j = i - 1; j >= 0; j--) {
                height = Math.max(height, books[j][1]);
                weight = weight + books[j][0];
                if (weight > shelf_width) {
                    break;
                }
                if (j == 0) {
                    dp[i] = Math.min(dp[i], height);
                } else {
                    dp[i] = Math.min(dp[i], dp[j - 1] + height);
                }
            }
        }
        return dp[n - 1];
    }
}