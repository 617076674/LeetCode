package question2147;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private static final int MOD = 1000000007;

  public int numberOfWays(String corridor) {
    int count = 0;
    List<Integer> indexes = new ArrayList<>();
    for (int i = 0; i < corridor.length(); i++) {
      if (corridor.charAt(i) == 'S') {
        count++;
        indexes.add(i);
      }
    }
    if (count == 0 || count % 2 != 0) {
      return 0;
    }
    long result = 1;
    for (int i = 2; i < indexes.size(); i += 2) {
      result *= indexes.get(i) - indexes.get(i - 1);
      result %= MOD;
    }
    return (int) result;
  }

}