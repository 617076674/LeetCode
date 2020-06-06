package question0600_non_negative_integers_without_consecutive_ones;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i] 表示长度为 i、首位为 1 的二进制串的个数。
 *
 * 初始化条件：
 * dp[1] = 1。
 * dp[2] = 1。
 *
 * 状态转移方程：
 * dp[i] = dp[i - 1] + dp[i - 2]。
 *
 * 对于一个数 num，一定存在某个数 bits，使得 num 在区间 [2 ^ (bits - 1), 2 ^ bits) 范围内。
 *
 * 对于区间 [2 ^ (bits - 1), 2 ^ bits) 范围内所有元素，其首位一定是 1，根据其第二位是 0 还是 1，可以将区间分成两半，前一部分以 10 开头，
 * 后一部分以 11 开头。
 * 如果 num 属于后一部分，那么结果就是 dp[1] + dp[2] + ... + dp[bits] + 1。
 * 如果 num 属于前一部分，在 [2 ^ (bits - 1), num] 范围内的无连续 1 的数的个数就等于 [0, num] 范围内的无连续 1 的数的个数。
 *
 * 时间复杂度是 O(num)。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：36.6MB，击败100.00%。
 */
public class Solution2 {
    public int findIntegers(int num) {
        if (num == 3) {
            return 3;
        }
        int bits = 0, tmp = num;
        while (tmp > 0) {
            bits++;
            tmp >>= 1;
        }
        if (bits <= 2) {
            return num + 1;
        }
        int[] dp = new int[32];
        int result = 3;
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= bits - 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            result += dp[i];
        }
        if (num >= Math.pow(2, bits - 1) + Math.pow(2, bits - 2)) {
            return result + dp[bits - 1] + dp[bits - 2];
        }
        return result + findIntegers((int) (num - Math.pow(2, bits - 1)));
    }
}