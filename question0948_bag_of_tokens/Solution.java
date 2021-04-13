package question0948_bag_of_tokens;

import java.util.Arrays;

public class Solution {

  public int bagOfTokensScore(int[] tokens, int P) {
    Arrays.sort(tokens);
    int left = 0, right = tokens.length - 1, points = 0, result = 0;
    while (left <= right && (P >= tokens[left] || points > 0)) {
      while (left <= right && P >= tokens[left]) {
        P -= tokens[left++];
        points++;
      }
      result = Math.max(result, points);
      if (left <= right && points > 0) {
        P += tokens[right--];
        points--;
      }
    }
    return result;
  }

}