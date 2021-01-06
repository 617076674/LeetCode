package question1712_ways_to_split_array_into_three_subarrays;

public class Solution {

  private static final int MOD = 1000000007;

  private int[] sums;

  public int waysToSplit(int[] nums) {
    sums = new int[nums.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }
    long result = 0;
    for (int index1 = 0; index1 < nums.length - 2; index1++) {
      int left = sums[index1 + 1];
      // 在 [index1 + 1, nums.length - 2] 范围内寻找 index2，使得
      // (mid = sums[index2 + 1] - left) >= left，
      // 且 (right = sums[nums.length] - sums[index2 + 1]) >= mid。
      // 即 sums[index2 + 1] >= 2 * left && 2 * sums[index2 + 1] <= sums[nums.length] + left
      // 即 sums[index2 + 1] 在 [2 * left, (sums[nums.length] + left) / 2] 范围内
      int maxIndex2 = Math.min(nums.length - 1, ceil(sums, (sums[nums.length] + left) / 2));
      int minIndex2 = Math.max(index1 + 2, floor(sums, 2 * left));
      if (maxIndex2 >= minIndex2) {
        result += (long) maxIndex2 - (long) minIndex2 + 1;
      }
      result %= MOD;
    }
    return (int) result;
  }

  private int floor(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums[mid] == target) {
        right = mid - 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private int ceil(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums[mid] == target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return right;
  }

}