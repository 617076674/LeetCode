package question1330_reverse_subarray_to_maximize_array_value;

/**
 * 贪心算法。
 *
 * https://leetcode-cn.com/problems/reverse-subarray-to-maximize-array-value/solution/tan-xin-suan-fa-suan-fa-fu-za-du-on-by-tom-chan/
 */
public class Solution {

  public int maxValueAfterReverse(int[] nums) {
    int result = 0, addMin = Integer.MAX_VALUE, subMax = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length - 1; i++) {
      addMin = Math.min(addMin, Math.max(nums[i], nums[i + 1]));
      subMax = Math.max(subMax, Math.min(nums[i], nums[i + 1]));
      result += Math.abs(nums[i] - nums[i + 1]);
    }
    int temp = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      // 反转 [0, i]
      temp = Math.max(temp, Math.abs(nums[i + 1] - nums[0]) - Math.abs(nums[i + 1] - nums[i]));
    }
    for (int i = nums.length - 1; i > 0; i--) {
      // 反转 [i, nums.length - 1]
      temp = Math.max(temp, Math.abs(nums[i - 1] - nums[nums.length - 1]) - Math.abs(nums[i] - nums[i - 1]));
    }
    return result + Math.max(temp, (subMax - addMin) * 2);
  }

}