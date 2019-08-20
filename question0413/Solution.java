package question0413;

/**
 * @author qianyihui
 * @date 2019-08-20
 *
 * 状态定义：
 * dp[i]:以A[i]为结尾的等差数列的个数
 *
 * 状态转移：
 * 当i == 0或i == 1时，dp[i] = 0。
 *
 * 当i >= 2时，dp[i] = i - tmp - 1，其中[tmp, i]能构成以A[i]为结尾的最长等差数列
 *
 * 时间复杂度是O(n ^ 2)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败91.61%。消耗内存：34.8MB，击败68.13%。
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n, result = 0;
        if (null == A || (n = A.length) < 3) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = dp[1] = 0;
        for (int i = 2; i < n; i++) {
            int gap = A[i] - A[i - 1], tmp = i;
            do {
                tmp--;
            } while (tmp - 1 >= 0 && A[tmp] - A[tmp - 1] == gap);
            dp[i] = i - tmp - 1;
            result += dp[i];
        }
        return result;
    }
}
