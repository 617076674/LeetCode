package question1563_stone_game_v;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 2)，其中 n 为 stoneValue 数组的长度。
 *
 * 执行用时：187ms，击败64.31%。消耗内存：39.7MB，击败37.83%。
 */
public class Solution {

    private int[] sum;  // sum[i] = stoneValue[0] + ... + stoneValue[i]

    private int[][] memo;

    public int stoneGameV(int[] stoneValue) {
        sum = new int[stoneValue.length];
        sum[0] = stoneValue[0];
        for (int i = 1; i < stoneValue.length; i++) {
            sum[i] = sum[i - 1] + stoneValue[i];
        }
        memo = new int[stoneValue.length][stoneValue.length];
        return stoneGameV(stoneValue, 0, stoneValue.length - 1);
    }

    private int stoneGameV(int[] stoneValue, int left, int right) {
        if (left >= right) {
            return 0;
        }
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        int result = Integer.MIN_VALUE;
        // [left, mid], [mid + 1, right]
        for (int mid = left; mid <= right; mid++) {
            int leftSum = sum[mid];
            if (left > 0) {
                leftSum -= sum[left - 1];
            }
            int rightSum = sum[right] - sum[mid];
            if (leftSum == rightSum) {
                result = Math.max(result, Math.max(stoneGameV(stoneValue, left, mid), stoneGameV(stoneValue, mid + 1, right)) + leftSum);
            } else if (leftSum < rightSum) {
                result = Math.max(result, leftSum + stoneGameV(stoneValue, left, mid));
            } else {
                result = Math.max(result, rightSum + stoneGameV(stoneValue, mid + 1, right));
            }
        }
        memo[left][right] = result;
        return result;
    }

}