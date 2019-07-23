package question0188;

/**
 * 动态规划。
 *
 * 参考question0123的Solution3。
 *
 * 时间复杂度是O(kn)，其中n为prices数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：6ms，击败91.26%。消耗内存：37.1MB，击败44.18%。
 */
public class Solution1 {
    public int maxProfit(int k, int[] prices) {
        int result = 0, n = prices.length;
        if (0 == n || k == 0) {
            return result;
        }
        //如果交易的次数足够多，相当于不受限，那么就可以对每一个上升沿都进行一次交易。
        if(k >= prices.length / 2){
            for (int i = 1; i < prices.length; i++) {
                if(prices[i] > prices[i - 1]){
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }
        int[][] dp = new int[2][n];
        for (int i = 1; i <= k; i++) {
            int cur = (i & 1), next = ((i + 1) & 1);
            int min = prices[0];
            for (int j = 1; j < n; j++) {
                dp[cur][j] = Math.max(dp[cur][j - 1], prices[j] - min);
                min = Math.min(min, prices[j] - dp[next][j - 1]);
            }
        }
        if ((k & 1) == 0) {
            return dp[0][n - 1];
        }
        return dp[1][n - 1];
    }
}


