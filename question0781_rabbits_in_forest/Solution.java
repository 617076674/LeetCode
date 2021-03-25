package question0781_rabbits_in_forest;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int numRabbits(int[] answers) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int answer : answers) {
      map.put(answer, map.getOrDefault(answer, 0) + 1);
    }
    int result = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int temp = entry.getValue() / (entry.getKey() + 1);
      if (entry.getValue() % (entry.getKey() + 1) != 0) {
        temp++;
      }
      result += temp * (entry.getKey() + 1);
    }
    return result;
  }

}