package lcof51_shu_zu_zhong_de_ni_xu_dui;

public class Solution2 {

  private int result;

  public int reversePairs(int[] nums) {
    if (null == nums || nums.length == 0) {
      return 0;
    }
    mergeSort(nums, 0, nums.length - 1);
    return result;
  }

  private void mergeSort(int[] nums, int left, int right) {
    if (left == right) {
      return;
    }
    int mid = left + ((right - left) >> 1);
    // [left, mid] [mid + 1, right]
    mergeSort(nums, left, mid);
    mergeSort(nums, mid + 1, right);
    int[] copy = new int[right - left + 1];
    for (int i = 0; i < copy.length; i++) {
      copy[i] = nums[i + left];
    }
    int index1 = mid, index2 = right, index = right;
    while (index1 >= left || index2 > mid) {
      if (index1 < left) {
        nums[index--] = copy[index2 - left];
        index2--;
      } else if (index2 <= mid) {
        nums[index--] = copy[index1 - left];
        index1--;
      } else if (copy[index1 - left] > copy[index2 - left]) {
        result += index2 - mid;
        nums[index--] = copy[index1 - left];
        index1--;
      } else {
        nums[index--] = copy[index2 - left];
        index2--;
      }
    }
  }

}