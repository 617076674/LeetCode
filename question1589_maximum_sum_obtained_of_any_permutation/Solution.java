package question1589_maximum_sum_obtained_of_any_permutation;

import java.util.Arrays;

public class Solution {

  private static final int MOD = 1000000007;

  public int maxSumRangeQuery(int[] nums, int[][] requests) {
    int[] diff = new int[nums.length + 1];
    for (int[] request : requests) {
      diff[request[0]]++;
      diff[request[1] + 1]--;
    }
    long[] counts = new long[nums.length];
    for (int i = 0; i < counts.length; i++) {
      counts[i] = diff[i] + (i == 0 ? 0 : counts[i - 1]);
    }
    Integer[] indexes = new Integer[nums.length];
    for (int i = 0; i < indexes.length; i++) {
      indexes[i] = i;
    }
    Arrays.sort(indexes, (index1, index2) -> (int) (counts[index2] - counts[index1]));
    Arrays.sort(nums);
    int i = nums.length - 1;
    long result = 0L;
    for (int index : indexes) {
      if (counts[index] == 0) {
        break;
      }
      result += (counts[index] * nums[i--]) % MOD;
      result %= MOD;
    }
    return (int) result;
  }

}