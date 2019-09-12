package question0403;

import java.util.Arrays;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是O((n ^ 2) * log(n))，其中n为stones数组的长度。空间复杂度均是O(n ^ 2)。
 *
 * 执行用时：64ms，击败79.78%。消耗内存：71.7MB，击败15.22%。
 */
public class Solution1 {
    private int[][] dp;

    private int n;

    public boolean canCross(int[] stones) {
        if (stones[1] - stones[0] != 1) {
            return false;
        }
        n = stones.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return canCross(stones, 1, 1);
    }

    /**
     * 目前在stones数组的now索引处，上一步跳跃了preStep个单位，判断能否到达stones数组中的最后一个位置。
     */
    private boolean canCross(int[] stones, int now, int preStep) {
        if (now >= n) {
            return false;
        }
        if (now == n - 1) {
            return true;
        }
        if (dp[now][preStep] != -1) {
            return dp[now][preStep] == 1;
        }
        for (int step = preStep - 1; step <= preStep + 1; step++) {
            if (step == 0) {
                continue;
            }
            int index = binarySearch(stones, now + 1, n - 1, stones[now] + step);
            if (index != -1 && canCross(stones, index, step)) {
                dp[now][preStep] = 1;
                return true;
            }
        }
        dp[now][preStep] = 0;
        return false;
    }

    private int binarySearch(int[] stones, int left, int right, int target) {
        if (left > right || (left == right && stones[left] != target)) {
            return -1;
        }
        int mid = left + ((right - left) >> 1);
        if (target == stones[mid]) {
            return mid;
        } else if (target > stones[mid]) {
            return binarySearch(stones, mid + 1, right, target);
        } else {
            return binarySearch(stones, left, mid - 1, target);
        }
    }
}
