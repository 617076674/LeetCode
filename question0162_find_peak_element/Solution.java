package question0162_find_peak_element;

public class Solution {

  public int findPeakElement(int[] nums) {
    return findPeakElement(nums, 0, nums.length - 1);
  }

  private int findPeakElement(int[] nums, int left, int right) {
    if (left == right) {
      return left;
    }
    int mid = left + ((right - left) >> 1);
    if (mid + 1 < nums.length) {
      if (mid - 1 >= 0) {
        if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
          return mid;
        }
        if (nums[mid + 1] > nums[mid - 1]) {
          return findPeakElement(nums, mid + 1, right);
        }
        return findPeakElement(nums, left, mid - 1);
      }
      if (nums[mid] > nums[mid + 1]) {
        return mid;
      }
      return findPeakElement(nums, mid + 1, right);
    }
    if (nums[mid] > nums[mid - 1]) {
      return mid;
    }
    return findPeakElement(nums, left, mid - 1);
  }

}