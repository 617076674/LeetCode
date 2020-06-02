package question1423_maximum_points_you_can_obtain_from_cards;

/**
 * 换个角度想问题。
 *
 * 在原数组 cardPoints 中取一个长度为 n - k 的子数组，其中 n 为数组 cardPoints 的长度，使得该子数组和最小，那么手中的卡牌点数之和就是最大。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：3ms，击败39.21%。消耗内存：47.9MB，击败100.00%。
 */
public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] sum = new int[n];
        sum[0] = cardPoints[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + cardPoints[i];
        }
        if (k == n) {
            return sum[n - 1];
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            if (i == 0) {
                result = Math.max(result, sum[n - 1] - sum[i + n - k - 1]);
            } else {
                result = Math.max(result, sum[n - 1] - sum[i + n - k - 1] + sum[i - 1]);
            }
        }
        return result;
    }
}