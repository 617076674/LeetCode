package question0413_arithmetic_slices;

/**
 * 状态定义：
 *
 * dp[i]：以A[i]为结尾的等差数列的个数
 *
 * 状态转移：
 *
 * （1）当i == 0或i == 1时，dp[i] = 0。
 *
 * （2）当i >= 2时，dp[i] = dp[i - 1] + 1，A[i - 2], A[i - 1], A[i]能构成一个等差数列
 *
 * 时间复杂度是O(n ^ 2)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败91.61%。消耗内存：34.8MB，击败68.13%。
 */
public class Solution1 {
    public int numberOfArithmeticSlices(int[] A) {
        int n, result = 0;
        if (null == A || (n = A.length) < 3) {
            return 0;
        }
        int dp = 0;
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp++;
            } else {
                dp = 0;
            }
            result += dp;
        }
        return result;
    }
}