package question1639_number_of_ways_to_form_a_target_string_given_a_dictionary;

import java.util.Arrays;

/**
 * 背包问题。
 *
 * 时间复杂度和空间复杂度均是 O(m * n)，其中 m 为字符串 target 的长度，n 为 words 数组中的字符串长度。
 *
 * 执行用时：568ms，击败11.00%。消耗内存：54.2MB，击败40.86%。
 */
public class Solution {

  private static final int MOD = 1000000007;

  private long[][] memo;

  private int[][] index2Char2Count;

  public int numWays(String[] words, String target) {
    memo = new long[words[0].length()][target.length()];
    for (int i = 0; i < memo.length; i++) {
      Arrays.fill(memo[i], -1);
    }
    index2Char2Count = new int[words[0].length()][26];
    for (int i = 0; i < words[0].length(); i++) {
      for (int j = 0; j < 26; j++) {
        for (int k = 0; k < words.length; k++) {
          if (words[k].charAt(i) - 'a' == j) {
            index2Char2Count[i][j]++;
          }
        }
      }
    }
    return (int) numWays(words, target, 0, 0);
  }

  /**
   * 利用数组 words 中索引大于等于 index1 字符去组建 target 中 [index2, target.length() - 1] 中的字符串
   */
  private long numWays(String[] words, String target, int index1, int index2) {
    if (index1 == words[0].length()) {
      if (index2 == target.length()) {
        return 1;
      }
      return 0;
    }
    if (index2 == target.length()) {
      return 1;
    }
    if (memo[index1][index2] != -1) {
      return memo[index1][index2];
    }
    memo[index1][index2] = numWays(words, target, index1 + 1, index2);
    int count = index2Char2Count[index1][target.charAt(index2) - 'a'];
    if (count > 0) {
      memo[index1][index2] += count * numWays(words, target, index1 + 1, index2 + 1);
      memo[index1][index2] %= MOD;
    }
    return memo[index1][index2];
  }

}