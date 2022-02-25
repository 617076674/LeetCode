package lcci1011_peaks_and_valleys;

public class Solution {

  public void wiggleSort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (i % 2 == 0) {
        // 当前位置是峰
        if (nums[i] < nums[i - 1]) {
          swap(nums, i - 1, i);
        }
      } else {
        // 当前位置是谷
        if (nums[i] > nums[i - 1]) {
          swap(nums, i - 1, i);
        }
      }
    }
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    System.out.println(null instanceof Object);
  }

}