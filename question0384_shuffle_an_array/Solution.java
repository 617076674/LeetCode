package question0384_shuffle_an_array;

import java.util.Random;

public class Solution {

  private int[] origin;

  private int[] copy;

  private static final Random random = new Random();

  public Solution(int[] nums) {
    origin = nums;
    copy = new int[nums.length];
    System.arraycopy(nums, 0, copy, 0, nums.length);
  }

  public int[] reset() {
    return origin;
  }

  public int[] shuffle() {
    int n = origin.length;
    while (n >= 1) {
      swap(copy, random.nextInt(n), --n);
    }
    return copy;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}