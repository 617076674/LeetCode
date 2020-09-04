package question1402_reducing_dishes;

import java.util.Arrays;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 2)，其中 n 为数组 satisfaction 的长度。
 *
 * 执行用时：26ms，击败5.23%。消耗内存：49.2MB，击败5.30%。
 */
public class Solution {
    private Integer[][] memo;

    private int n;

    public int maxSatisfaction(int[] satisfaction) {
        n = satisfaction.length;
        Arrays.sort(satisfaction);
        memo = new Integer[n][n];
        return maxSatisfaction(satisfaction, 0, 0);
    }

    private int maxSatisfaction(int[] satisfaction, int index, int count) {
        if (index >= n) {
            return 0;
        }
        if (null != memo[index][count]) {
            return memo[index][count];
        }
        memo[index][count] = Math.max((count + 1) * satisfaction[index] + maxSatisfaction(satisfaction, index + 1, count + 1), maxSatisfaction(satisfaction, index + 1, count));
        return memo[index][count];
    }
}