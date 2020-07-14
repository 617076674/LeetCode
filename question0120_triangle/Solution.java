package question0120_triangle;

import java.util.List;

/**
 * 时间复杂度是 O(n ^ 2)，其中 n 为 triangle 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：2ms，击败96.02%。消耗内存：40MB，击败8.70%。
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0); // 第0层
        for (int i = 1; i < triangle.size(); i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp) {
            min = Math.min(num, min);
        }
        return min;
    }
}