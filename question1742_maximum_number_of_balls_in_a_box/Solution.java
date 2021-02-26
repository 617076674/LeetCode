package question1742_maximum_number_of_balls_in_a_box;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int countBalls(int lowLimit, int highLimit) {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    for (int i = lowLimit; i <= highLimit; i++) {
      int index = sum(i);
      map.put(index, map.getOrDefault(index, 0) + 1);
      max = Math.max(max, map.get(index));
    }
    return max;
  }

  private static int sum(int num) {
    int result = 0;
    while (num > 0) {
      result += num % 10;
      num /= 10;
    }
    return result;
  }

}