package question1569_number_of_ways_to_reorder_array_to_get_same_bst;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.bilibili.com/video/av371979293/
 *
 * 执行用时：196ms，击败35.19%。消耗内存：55.3MB，击败34.06%。
 */
public class Solution {

  private static final int MOD = 1000000007;

  private long[][] memo;

  public int numOfWays(int[] nums) {
    List<Integer> numList = new ArrayList<>();
    for (int num : nums) {
      numList.add(num);
    }
    memo = new long[nums.length][nums.length];
    return (int) numOfWays(numList) - 1;
  }

  private long numOfWays(List<Integer> nums) {
    if (nums.size() <= 2) {
      return 1;
    }
    List<Integer> lessList = new ArrayList<>(), greaterList = new ArrayList<>();
    for (int num : nums) {
      if (num < nums.get(0)) {
        lessList.add(num);
      } else if (num > nums.get(0)) {
        greaterList.add(num);
      }
    }
    long result = combination(lessList.size() + greaterList.size(), lessList.size());
    result = result * numOfWays(lessList) % MOD;
    result = result * numOfWays(greaterList) % MOD;
    return result;
  }

  private long combination(int n, int k) {
    if (k == 0 || k == n) {
      return 1;
    }
    if (memo[n][k] != 0) {
      return memo[n][k];
    }
    memo[n][k] = combination(n - 1, k) + combination(n - 1, k - 1);
    memo[n][k] %= MOD;
    return memo[n][k];
  }

}