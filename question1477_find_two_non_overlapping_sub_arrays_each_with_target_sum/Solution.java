package question1477_find_two_non_overlapping_sub_arrays_each_with_target_sum;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：9ms，击败87.64%。消耗内存：48.6MB，击败77.55%。
 */
public class Solution {

    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // dp[i] 表示 [0, i] 范围内最短的合法子数组长度
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int result = Integer.MAX_VALUE, sum = 0, left = 0, right = 0, minLen = Integer.MAX_VALUE;
        while (right < n) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left++];
            }
            if (sum == target) {
                int curLen = right - left + 1;
                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, curLen + dp[left - 1]);
                }
                minLen = Math.min(minLen, curLen);
            }
            dp[right] = minLen;
            right++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}