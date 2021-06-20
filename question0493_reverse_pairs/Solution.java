package question0493_reverse_pairs;

public class Solution {

  public int reversePairs(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    return reversePairsRecursive(nums, 0, nums.length - 1);
  }

  public int reversePairsRecursive(int[] nums, int left, int right) {
    if (left == right) {
      return 0;
    }
    int mid = left + ((right - left) >> 1), resultLeft = reversePairsRecursive(nums, left, mid),
        resultRight = reversePairsRecursive(nums, mid + 1, right),
        result = resultLeft + resultRight;
    // 首先统计下标对的数量
    int i = left, j = mid + 1;
    while (i <= mid) {
      while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
        j++;
      }
      result += j - mid - 1;
      i++;
    }
    // 随后合并两个排序数组
    int[] copy = new int[right - left + 1];
    int index1 = left, index2 = mid + 1, index = 0;
    while (index1 <= mid || index2 <= right) {
      if (index1 > mid) {
        copy[index++] = nums[index2++];
      } else if (index2 > right) {
        copy[index++] = nums[index1++];
      } else {
        if (nums[index1] < nums[index2]) {
          copy[index++] = nums[index1++];
        } else {
          copy[index++] = nums[index2++];
        }
      }
    }
    for (int k = 0; k < copy.length; k++) {
      nums[left + k] = copy[k];
    }
    return result;
  }

}