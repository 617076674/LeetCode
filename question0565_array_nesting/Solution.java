package question0565_array_nesting;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int arrayNesting(int[] nums) {
    int result = 0;
    int[] dp = new int[nums.length];
    // dp[i] 表示以 A[i] 为第一个元素，对应的最大的集合 S 的大小
    for (int i = 0; i < nums.length; i++) {
      // 以 A[i] 为第一个元素，求最大的集合 S 的大小
      if (dp[i] == 0) {
        int len = 1, j = i;
        Set<Integer> visited = new HashSet<>();
        visited.add(i);
        while (true) {
          j = nums[j];
          if (j == i) {
            break;
          }
          visited.add(j);
          len++;
        }
        for (int index : visited) {
          dp[index] = len;
        }
        result = Math.max(result, dp[i]);
      }
    }
    return result;
  }

}