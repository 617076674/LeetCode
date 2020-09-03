package question1269_number_of_ways_to_stay_in_the_same_place_after_some_steps;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O(arrLen * steps)。空间复杂度是 O(steps * steps)。
 *
 * 执行用时：12ms，击败92.45%。消耗内存：41MB，击败33.33%。
 */
public class Solution {
    private long[][] memo;

    private static final int MOD = 1000000007;

    public int numWays(int steps, int arrLen) {
        memo = new long[steps + 1][steps + 1];
        return (int) numWays(0, steps, arrLen);
    }

    /**
     * 当前所处位置为 now，经过 steps 步后指针回到索引 0 处的方案数。
     */
    private long numWays(int now, int steps, int arrLen) {
        if (now >= arrLen || now < 0 || now > steps) {
            return 0;
        }
        if (steps == 0) {
            return 1;
        }
        if (memo[now][steps] != 0) {
            return memo[now][steps];
        }
        memo[now][steps] = (numWays(now, steps - 1, arrLen) + numWays(now + 1, steps - 1, arrLen) + numWays(now - 1, steps - 1, arrLen)) % MOD;
        return memo[now][steps];
    }
}