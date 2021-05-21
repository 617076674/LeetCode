package question1850_minimum_adjacent_swaps_to_reach_the_kth_smallest_number;

/**
 * LeetCode0031
 */
public class Solution {

  public int getMinSwaps(String num, int k) {
    int[] nums = new int[num.length()], origin = new int[num.length()];
    for (int i = 0; i < num.length(); i++) {
      nums[i] = origin[i] = num.charAt(i) - '0';
    }
    for (int i = 0; i < k; i++) {
      nextPermutation(nums);
    }
    int result = 0;
    for (int i = 0; i < num.length(); i++) {
      if (origin[i] != nums[i]) {
        int j = i + 1;
        while (origin[j] != nums[i]) {
          j++;
        }
        while (j != i) {
          swap(j - 1, j, origin);
          result++;
          j--;
        }
      }
    }
    return result;
  }


  private static void nextPermutation(int[] nums) {
    int n = nums.length, i = n - 1;
    for (; i >= 1; i--) {
      if (nums[i] > nums[i - 1]) {    //如果存在第i个数比第(i - 1)个数更大的情况，说明存在下一个更大的排列
        break;
      }
    }
    if (i >= 1) {   //存在下一个更大的排列
      int j = n - 1;
      for (; j >= i; j--) {
        if (nums[j] > nums[i - 1]) {    //寻找到比第(i - 1)个数更大的数，其索引是j
          break;
        }
      }
      swap(i - 1, j, nums);   //交换第(i - 1)个数和第j个数
      reverse(nums, i);   //此时[i, n - 1]仍然是一个降序排列，将其反转为一个升序排列
    } else {    //不存在下一个更大的排列
      reverse(nums, 0);
    }
  }

  private static void reverse(int[] nums, int index) {
    int i = index, j = nums.length - 1;
    while (i < j) {
      swap(i, j, nums);
      i++;
      j--;
    }
  }

  private static void swap(int i, int j, int[] nums) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

}