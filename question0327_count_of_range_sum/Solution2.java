package question0327_count_of_range_sum;

/**
 * 时间复杂度是 O(nlogn)，其中 n 为数组 nums 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：7ms，击败99.77%。消耗内存：38.5MB，击败91.69%。
 */
public class Solution2 {

  public int countRangeSum(int[] nums, int lower, int upper) {
    long[] sum = new long[nums.length + 1];   // sum[i] = nums[0] + ... + nums[i - 1]
    for (int i = 1; i <= nums.length; i++) {
      sum[i] = sum[i - 1] + nums[i - 1];
    }
    return countRangeSum(sum, lower, upper, 0, sum.length - 1);
  }

  // sum[left] = nums[0] + ... + nums[left - 1]
  // sum[right] = nums[0] + ... + nums[right - 1]
  // 在 [left, right] 范围内的下标 (i,j) 对数，和为 nums[i] + ... + nums[j - 1] 在 [lower, upper] 范围内
  private int countRangeSum(long[] sum, int lower, int upper, int left, int right) {
    if (left >= right) {
      return 0;
    }
    int mid = left + ((right - left) >> 1);
    int resultLeft = countRangeSum(sum, lower, upper, left, mid);
    int resultRight = countRangeSum(sum, lower, upper, mid + 1, right);
    int result = resultLeft + resultRight;
    int i = left, j = mid + 1, k = mid + 1;
    while (i <= mid) {
      while (j <= right && sum[j] - sum[i] < lower) {
        j++;
      }
      while (k <= right && sum[k] - sum[i] <= upper) {
        k++;
      }
      result += k - j;
      i++;
    }
    long[] sorted = new long[right - left + 1];
    int index1 = left, index2 = mid + 1, index = 0;
    while (index1 <= mid || index2 <= right) {
      if (index1 > mid) {
        sorted[index++] = sum[index2++];
      } else if (index2 > right) {
        sorted[index++] = sum[index1++];
      } else if (sum[index1] < sum[index2]) {
        sorted[index++] = sum[index1++];
      } else {
        sorted[index++] = sum[index2++];
      }
    }
    for (int l = 0; l < sorted.length; l++) {
      sum[left + l] = sorted[l];
    }
    return result;
  }

}