package question0689_maximum_sum_of_3_non_overlapping_subarrays;

import java.util.Arrays;

/**
 * 动态规划
 */
public class Solution3 {

  private int[] sums;

  private int[][][] memo;

  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    sums = new int[nums.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }
    memo = new int[nums.length][4][4];
    for (int i = 0; i < memo.length; i++) {
      for (int j = 0; j < memo[i].length; j++) {
        Arrays.fill(memo[i][j], -1);
      }
    }
    return maxSumOfThreeSubarrays(k, nums.length - 1, 3);
  }

  public static void main(String[] args) {
    int[] nums = {1,2,1,2,1,2,1,2,1};
    int k = 2;
    System.out.println(Arrays.toString(new Solution3().maxSumOfThreeSubarrays(nums, k)));
  }

  // 在 [0, index] 范围内找 count 个长度为 k 的子串，其和为最大，返回子串的起始值的位置
  private int[] maxSumOfThreeSubarrays(int k, int index, int count) {
    if (count * k > index + 1) {
      return null;
    }
    if (memo[index][count][0] != -1) {
      return memo[index][count];
    }
    if (count == 1) {
      int[] result = new int[1];
      for (int i = 1; i <= index - k + 1; i++) {
        if (sums[i + k] - sums[i] > sums[result[0] + k] - sums[result[0]]) {
          result[0] = i;
        }
      }
      memo[index][count] = result;
      return result;
    }
    // 取第 index 个数
    int[] result = new int[count];
    int[] temp1 = maxSumOfThreeSubarrays(k, index - k, count - 1);
    if (null != temp1) {
      int sum1 = 0;
      for (int value : temp1) {
        sum1 += sums[value + k] - sums[value];
      }
      sum1 += sums[index + 1] - sums[index - k + 1];
      System.arraycopy(temp1, 0, result, 0, temp1.length);
      result[result.length - 1] = index - k + 1;
      int[] temp2 = maxSumOfThreeSubarrays(k, index - 1, count);
      if (temp2 != null) {
        int sum2 = 0;
        for (int i = 0; i < temp2.length; i++) {
          sum2 += sums[temp2[i] + k] - sums[temp2[i]];
        }
        if (sum2 > sum1 || (sum1 == sum2 && less(temp2, result))) {
          memo[index][count] = temp2;
          return temp2;
        }
      }
      memo[index][count] = result;
      return result;
    }
    memo[index][count] = maxSumOfThreeSubarrays(k, index - 1, count);
    return memo[index][count];
  }

  // 如果字典序 nums1 比 nums2 小，返回true
  private boolean less(int[] nums1, int[] nums2) {
    for (int i = 0; i < nums1.length; i++) {
      if (nums1[i] < nums2[i]) {
        return true;
      }
    }
    return false;
  }
}
