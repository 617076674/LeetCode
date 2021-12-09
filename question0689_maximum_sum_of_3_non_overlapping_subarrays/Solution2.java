package question0689_maximum_sum_of_3_non_overlapping_subarrays;

/**
 * 滑动窗口法
 */
public class Solution2 {

  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int[] result = new int[3];
    int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
    int sum2 = 0, maxSum12 = 0, maxSum12Idx1 = 0, maxSum12Idx2 = 0;
    int sum3 = 0, maxTotal = 0;
    for (int i = k * 2; i < nums.length; ++i) {
      sum1 += nums[i - k * 2];
      sum2 += nums[i - k];
      sum3 += nums[i];
      if (i >= k * 3 - 1) {
        if (sum1 > maxSum1) {
          maxSum1 = sum1;
          maxSum1Idx = i - k * 3 + 1;
        }
        if (maxSum1 + sum2 > maxSum12) {
          maxSum12 = maxSum1 + sum2;
          maxSum12Idx1 = maxSum1Idx;
          maxSum12Idx2 = i - k * 2 + 1;
        }
        if (maxSum12 + sum3 > maxTotal) {
          maxTotal = maxSum12 + sum3;
          result[0] = maxSum12Idx1;
          result[1] = maxSum12Idx2;
          result[2] = i - k + 1;
        }
        sum1 -= nums[i - k * 3 + 1];
        sum2 -= nums[i - k * 2 + 1];
        sum3 -= nums[i - k + 1];
      }
    }
    return result;
  }

}