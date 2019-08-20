package question0877;

/**
 * @author qianyihui
 * @date 2019-08-19
 *
 * 对Solution2的空间复杂度优化。
 *
 * 时间复杂度是O(n ^ 2)，其中n为piles数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：20ms，击败29.17%。消耗内存：41.5MB，击败14.73%。
 */
public class Solution3 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];
        int[] sum = new int[n];
        sum[0] = piles[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + piles[i];
        }
        for (int i = 0; i < n; i++) {
            dp[i] = piles[i];
        }
        for (int gap = -1; gap >= 1 - n; gap--) {
            for (int i = 0; i < n + gap; i++) {
                int j = i - gap, total = sum[j];
                if (i > 0) {
                    total -= sum[i - 1];
                }
                dp[i] = Math.max(total - dp[i + 1], total - dp[i]);
            }
        }
        int first = dp[0];
        int second = sum[n - 1] - first;
        if (first > second) {
            return true;
        }
        return false;
    }
}
