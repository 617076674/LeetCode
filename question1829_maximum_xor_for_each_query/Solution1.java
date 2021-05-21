package question1829_maximum_xor_for_each_query;

public class Solution1 {

  public int[] getMaximumXor(int[] nums, int maximumBit) {
    int[] result = new int[nums.length];
    int temp = 0;
    for (int i = result.length - 1; i >= 0; i--) {
      temp ^= nums[nums.length - i - 1];
      result[i] = findK(temp, maximumBit);
    }
    return result;
  }

  private static int findK(int temp, int maximumBit) {
    int k = 0;
    for (int i = maximumBit - 1; i >= 0; i--) {
      if ((temp & (1 << i)) == 0) {
        k |= (1 << i);
      }
    }
    return k;
  }

}