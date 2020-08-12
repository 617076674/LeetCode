package question1125_smallest_sufficient_team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示考虑 people 中 [0, i - 1] 范围内的人，达到状态 j 所需的最少人数。
 *
 * 初始化条件：
 * dp[0][0] = 0。
 *
 * 状态转移方程：
 * dp[i][j | k] = min(dp[i - 1][j | k], dp[i][j] + 1)。
 *
 * 时间复杂度是 O(m * (2 ^ n))，其中 m 为人数，n 为 req_skills 数组的长度。空间复杂度是 O(m * n)。
 *
 * 执行用时：43ms，击败41.38%。消耗内存：68.9MB，击败44.00%。
 */
public class Solution {
  public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
    int n = req_skills.length;
    Map<String, Integer> stringToInteger = new HashMap<>();
    for (int i = 0; i < n; i++) {
      stringToInteger.put(req_skills[i], i);
    }
    List<Integer> skills = new ArrayList<>();
    for (List<String> list : people) {
      int k = 0;
      for (String s : list) {
        k |= (1 << stringToInteger.get(s));
      }
      skills.add(k);
    }
    int[][] dp = new int[people.size() + 1][1 << n];
    Arrays.fill(dp[0], Integer.MAX_VALUE / 2);
    dp[0][0] = 0;
    int[][] parent = new int[1 << n][2];
    for (int i = 1; i < dp.length; i++) {
      int k = skills.get(i - 1);
      for (int j = 0; j < dp[0].length; j++) {
        dp[i][j] = dp[i - 1][j];
      }
      if (k != 0) {
        for (int j = 0; j < dp[0].length; j++) {
          if (dp[i - 1][j] + 1 < dp[i][j | k]) {
            dp[i][j | k] = dp[i - 1][j] + 1;
            parent[j | k] = new int[] {i - 1, j};
          }
        }
      }
    }
    int[] result = new int[dp[people.size()][(1 << n) - 1]];
    int index = 0, status = (1 << n) - 1;
    while (status != 0) {
      result[index++] = parent[status][0];
      status = parent[status][1];
    }
    return result;
  }
}