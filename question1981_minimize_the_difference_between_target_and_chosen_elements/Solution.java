package question1981_minimize_the_difference_between_target_and_chosen_elements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  private Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();

  public int minimizeTheDifference(int[][] mat, int target) {
    for (int i = 0; i < mat.length; i++) {
      Arrays.sort(mat[i]);
    }
    return minimizeTheDifference(mat, 0, target);
  }

  private int minimizeTheDifference(int[][] mat, int begin, int target) {
    if (begin == mat.length) {
      return Math.abs(target);
    }
    if (target < 0) {
      int result = -target;
      for (int i = begin; i < mat.length; i++) {
        result += mat[i][0];
      }
      return result;
    }
    Map<Integer, Integer> map = memo.get(begin);
    if (null != map) {
      Integer result = map.get(target);
      if (null != result) {
        return result;
      }
    }
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < mat[begin].length; i++) {
      int selected = mat[begin][i];
      result = Math.min(result, minimizeTheDifference(mat, begin + 1, target - selected));
    }
    if (null != map) {
      map.put(target, result);
    } else {
      map = new HashMap<>();
      map.put(target, result);
      memo.put(begin, map);
    }
    return result;
  }

}