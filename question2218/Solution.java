package question2218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public int maxValueOfCoins(List<List<Integer>> piles, int k) {
    List<List<Integer>> sumsList = new ArrayList<>();
    for (List<Integer> pile : piles) {
      List<Integer> sumList = new ArrayList<>();
      sumList.add(0);
      for (int i = 0; i < pile.size(); i++) {
        sumList.add(pile.get(i) + sumList.get(sumList.size() - 1));
      }
      sumsList.add(sumList);
    }
    int[] dp = new int[k + 1];
    Arrays.fill(dp, Integer.MIN_VALUE);
    dp[0] = 0;
    for (int i = 0; i < piles.size(); i++) {
      for (int j = k; j >= 0; j--) {
        for (int l = 0; l <= piles.get(i).size(); l++) {
          if (j >= l) {
            dp[j] = Math.max(dp[j], dp[j - l] + sumsList.get(i).get(l));
          }
        }
      }
    }
    return dp[k];
  }

}