package question0583_delete_operation_for_two_strings;

public class Solution {

  private Integer[][] memo;

  public int minDistance(String word1, String word2) {
    memo = new Integer[word1.length()][word2.length()];
    return minDistance(word1, word1.length() - 1, word2, word2.length() - 1);
  }

  // 要使得 [0, index1] 处的 word1 和 [0, index2] 处的 word2 相同，需要删除多少个字符
  private int minDistance(String word1, int index1, String word2, int index2) {
    if (index1 == -1) {
      return index2 + 1;
    }
    if (index2 == -1) {
      return index1 + 1;
    }
    if (null == memo[index1][index2]) {
      if (word1.charAt(index1) == word2.charAt(index2)) {
        memo[index1][index2] = minDistance(word1, index1 - 1, word2, index2 - 1);
      } else {
        memo[index1][index2] = 1 + Math.min(minDistance(word1, index1 - 1, word2, index2),
            minDistance(word1, index1, word2, index2 - 1));
      }
    }
    return memo[index1][index2];
  }

}