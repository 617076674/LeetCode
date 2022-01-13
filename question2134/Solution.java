package question2134;

public class Solution {

  public int minSwaps(int[] nums) {
    int count1 = 0;
    for (int num : nums) {
      if (num == 1) {
        count1++;
      }
    }
    // 找长度为 count1 的一段 1，或者找长度为 nums.length - count1 的一段 0
    return Math.min(minSwapsHelper1(nums, count1), minSwapsHelper2(nums, nums.length - count1));
  }

  private static int minSwapsHelper1(int[] nums, int count) {
    int tempCount0 = 0, tempCount1 = 0;
    for (int i = 0; i < count; i++) {
      if (nums[i] == 0) {
        tempCount0++;
      } else {
        tempCount1++;
      }
    }
    int result = count - tempCount1;
    int left = 0, right = count;
    while (right < nums.length) {
      if (nums[right] == 0) {
        tempCount0++;
      } else {
        tempCount1++;
      }
      if (nums[left] == 0) {
        tempCount0--;
      } else {
        tempCount1--;
      }
      result = Math.min(result, count - tempCount1);
      left++;
      right++;
    }
    return result;
  }

  private static int minSwapsHelper2(int[] nums, int count) {
    int tempCount0 = 0, tempCount1 = 0;
    for (int i = 0; i < count; i++) {
      if (nums[i] == 0) {
        tempCount0++;
      } else {
        tempCount1++;
      }
    }
    int result = count - tempCount0;
    int left = 0, right = count;
    while (right < nums.length) {
      if (nums[right] == 0) {
        tempCount0++;
      } else {
        tempCount1++;
      }
      if (nums[left] == 0) {
        tempCount0--;
      } else {
        tempCount1--;
      }
      result = Math.min(result, count - tempCount0);
      left++;
      right++;
    }
    return result;
  }

}