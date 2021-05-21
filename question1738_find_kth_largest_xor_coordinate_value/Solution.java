package question1738_find_kth_largest_xor_coordinate_value;

public class Solution {

  public int kthLargestValue(int[][] matrix, int k) {
    int m = matrix.length, n = matrix[0].length;
    int[][] values = new int[m][n];
    int[] nums = new int[m * n];
    int index = 0;
    values[0][0] = matrix[0][0];
    nums[index++] = values[0][0];
    for (int j = 1; j < n; j++) {
      values[0][j] = values[0][j - 1] ^ matrix[0][j];
      nums[index++] = values[0][j];
    }
    for (int i = 1; i < m; i++) {
      values[i][0] = values[i - 1][0] ^ matrix[i][0];
      nums[index++] = values[i][0];
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        values[i][j] = values[i - 1][j] ^ values[i][j - 1] ^ values[i - 1][j - 1] ^ matrix[i][j];
        nums[index++] = values[i][j];
      }
    }
    return findKthLargestValue(nums, k);
  }

  private static int findKthLargestValue(int[] nums, int k) {
    return findKthLargestValue(nums, 0, nums.length - 1, k);
  }

  private static int findKthLargestValue(int[] nums, int left, int right, int k) {
    if (left == right) {
      return nums[left];
    }
    swap(nums, left, (int) (Math.random() * (right - left)) + left);
    //[left + 1, lessThan]   [lessThan + 1, i)     [greaterThan, right]
    int lessThan = left, i = left + 1, greaterThan = right + 1;
    while (i < greaterThan) {
      if (nums[i] == nums[left]) {
        i++;
      } else if (nums[i] < nums[left]) {
        lessThan++;
        swap(nums, lessThan, i);
        i++;
      } else {
        greaterThan--;
        swap(nums, i, greaterThan);
      }
    }
    swap(nums, left, lessThan);
    lessThan--;
    //[left, lessThan]   [lessThan + 1, greaterThan - 1]  [greaterThan, right]
    if (k <= right - greaterThan + 1) {
      return findKthLargestValue(nums, greaterThan, right, k);
    } else if (k > right - lessThan) {
      return findKthLargestValue(nums, left, lessThan, k - right + lessThan);
    }
    return nums[lessThan + 1];
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}