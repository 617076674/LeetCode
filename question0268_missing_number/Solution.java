package question0268_missing_number;

public class Solution {

  public int missingNumber(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] != i && nums[i] != nums.length) {
        swap(nums, i, nums[i]);
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i) {
        return i;
      }
    }
    return nums.length;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}