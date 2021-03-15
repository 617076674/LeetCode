package question1508_range_sum_of_sorted_subarray_sums;

public class Solution {

  private static final int MOD = 1000000007;

  public int rangeSum(int[] nums, int n, int left, int right) {
    int[] sums = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }
    int[] result = new int[n * (n + 1) / 2];
    int index = 0;
    for (int len = 1; len <= nums.length; len++) {
      for (int i = 0; i <= nums.length - len; i++) {
        // [i, i + len - 1]
        result[index++] = sums[i + len] - sums[i];
      }
    }
    findKthNumber(result, 0, result.length - 1, right - 1);
    long sumRight = 0;
    for (int i = 0; i < right; i++) {
      sumRight += result[i];
    }
    int leftNum = findKthNumber(result, 0, result.length - 1, left - 1);
    long sumLeft = 0;
    for (int i = 0; i < left; i++) {
      sumLeft += result[i];
    }
    return (int) ((sumRight - sumLeft + leftNum) % MOD);
  }

  /**
   * 寻找nums数组中[left, right]范围内的第K小数，K从0开始计数
   */
  private int findKthNumber(int[] nums, int left, int right, int K) {
    if (left == right && K == 0) {
      return nums[left];
    }
    swap(nums, left, (int) (Math.random() * (right - left) + left + 1));
    //[left + 1, lessThan], [lessThan + 1, i), [greaterThan, right]
    int lessThan = left, i = lessThan + 1, greaterThan = right + 1;
    while (i < greaterThan) {
      if (nums[i] == nums[left]) {
        i++;
      } else if (nums[i] > nums[left]) {
        greaterThan--;
        swap(nums, i, greaterThan);
      } else {
        lessThan++;
        swap(nums, i, lessThan);
        i++;
      }
    }
    //[left + 1, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
    swap(nums, left, lessThan);
    lessThan--;
    //[left, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
    if (K <= lessThan - left) {
      return findKthNumber(nums, left, lessThan, K);
    } else if (K <= greaterThan - left - 1) {
      return nums[lessThan + 1];
    }
    return findKthNumber(nums, greaterThan, right, K - greaterThan + left);
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

}