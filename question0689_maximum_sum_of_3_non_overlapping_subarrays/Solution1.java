package question0689_maximum_sum_of_3_non_overlapping_subarrays;

/**
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为数组 nums 的长度。
 *
 * 执行用时：3ms，击败94.96%。消耗内存：42.2MB，击败100.00%。
 */
public class Solution1 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] window = new int[nums.length - k + 1]; // window[i] = window[i] + ... + window[i + k - 1]
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            if (i >= k - 1) {
                window[i - k + 1] = sum;
            }
        }
        int[] left = new int[window.length];    //left[i] = k 表示在 j ∈ [0, i] 范围内最大的 weight[j] 第一次出现的位置是 j == k
        int best = 0;
        for (int i = 0; i < window.length; i++) {
            if (window[i] > window[best]) {
                best = i;
            }
            left[i] = best;
        }
        int[] right = new int[window.length];   //right[i] = k 表示在 j ∈ [i, window.length - 1] 范围内最大的 weight[j] 第一次出现的位置是 j == k
        best = window.length - 1;
        for (int i = window.length - 1; i >= 0; i--) {
            if (window[i] >= window[best]) {
                best = i;
            }
            right[i] = best;
        }
        int[] result = {-1, -1, -1};
        for (int j = k; j < window.length - k; j++) {
            int i = left[j - k], l = right[j + k];
            if (result[0] == -1 || window[i] + window[j] + window[l] > window[result[0]] + window[result[1]] + window[result[2]]) {
                result[0] = i;
                result[1] = j;
                result[2] = l;
            }
        }
        return result;
    }
}