package question1754_largest_merge_of_two_strings;

public class Solution {

  private StringBuilder[][] memo;

  public String largestMerge(String word1, String word2) {
    memo = new StringBuilder[word1.length()][word2.length()];
    return largestMerge(word1, 0, word2, 0).toString();
  }

  private StringBuilder largestMerge(String word1, int index1, String word2, int index2) {
    if (index1 == word1.length()) {
      return new StringBuilder(word2.substring(index2));
    }
    if (index2 == word2.length()) {
      return new StringBuilder(word1.substring(index1));
    }
    if (memo[index1][index2] != null) {
      return memo[index1][index2];
    }
    if (word1.substring(index1).compareTo(word2.substring(index2)) < 0) {
      memo[index1][index2] = new StringBuilder().append(word2.charAt(index2)).append(largestMerge(word1, index1, word2, index2 + 1));
    } else {
      memo[index1][index2] = new StringBuilder().append(word1.charAt(index1)).append(largestMerge(word1, index1 + 1, word2, index2));
    }
    return memo[index1][index2];
  }

}