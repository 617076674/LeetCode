package question2012_sum_of_beauty_in_the_array;

public class Solution {

  public int sumOfBeauties(int[] nums) {
    // leftMax[i] 表示 nums 中 [0, i] 范围内的最大值
    // rightMin[i] 表示 nums 中 [i, nums.length - 1] 范围内的最小值
    int[] leftMax = new int[nums.length], rightMin = new int[nums.length];
    leftMax[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
    }
    rightMin[nums.length - 1] = nums[nums.length - 1];
    for (int i = nums.length - 2; i >= 0; i--) {
      rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
    }
    int result = 0;
    for (int i = 1; i <= nums.length - 2; i++) {
      if (nums[i] > leftMax[i - 1] && nums[i] < rightMin[i + 1]) {
        result += 2;
      } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
        result++;
      }
    }
    return result;
  }

}