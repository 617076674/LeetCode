package question1711_count_good_meals;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  private static final int MOD = 1000000007;

  public int countPairs(int[] deliciousness) {
    Map<Integer, Long> map = new HashMap<>();
    for (int num : deliciousness) {
      map.put(num, map.getOrDefault(num, 0L) + 1);
    }
    long result = 0;
    for (int num : map.keySet()) {
      for (int i = 0; i <= 21; i++) {
        int another = (int) Math.pow(2, i) - num;
        if (another < num) {
          continue;
        }
        Long tmp = map.get(another);
        if (null == tmp) {
          continue;
        }
        if (Math.pow(2, i) - num == num) {
          result += tmp * (tmp - 1) / 2;
        } else {
          result += map.get(num) * tmp;
        }
        result %= MOD;
      }
    }
    return (int) result;
  }

}