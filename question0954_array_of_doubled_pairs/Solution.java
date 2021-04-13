package question0954_array_of_doubled_pairs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public boolean canReorderDoubled(int[] A) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : A) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    Integer[] copyA = new Integer[A.length];
    for (int i = 0; i < A.length; i++) {
      copyA[i] = A[i];
    }
    Arrays.sort(copyA, Comparator.comparingInt(Math::abs));
    for (int num : copyA) {
      if (map.get(num) == 0) {
        continue;
      }
      if (map.getOrDefault(2 * num, 0) <= 0) {
        return false;
      }
      map.put(num, map.get(num) - 1);
      map.put(2 * num, map.get(2 * num) - 1);
    }
    return true;
  }

}