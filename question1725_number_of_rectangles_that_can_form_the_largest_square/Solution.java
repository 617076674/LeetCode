package question1725_number_of_rectangles_that_can_form_the_largest_square;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int countGoodRectangles(int[][] rectangles) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxLen = Integer.MIN_VALUE;
    for (int[] rectangle : rectangles) {
      int len = Math.min(rectangle[0], rectangle[1]);
      maxLen = Math.max(len, maxLen);
      map.put(len, map.getOrDefault(len, 0) + 1);
    }
    return map.get(maxLen);
  }

}