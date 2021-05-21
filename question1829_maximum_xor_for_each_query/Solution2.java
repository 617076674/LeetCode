package question1829_maximum_xor_for_each_query;

public class Solution2 {

  public int[] getMaximumXor(int[] nums, int maximumBit) {
    int[] result = new int[nums.length];
    int temp = 0;
    for (int i = result.length - 1; i >= 0; i--) {
      temp ^= nums[nums.length - i - 1];
      result[i] = temp ^ ((1 << maximumBit) - 1);
    }
    return result;
  }

}