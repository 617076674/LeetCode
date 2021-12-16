package lcp20;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  private static final int MOD = 1000000007;

  private int inc;

  private int dec;

  private int[] jump;

  private int[] cost;

  private Map<Long, Long> memo = new HashMap<>();

  public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
    this.inc = inc;
    this.dec = dec;
    this.jump = jump;
    this.cost = cost;
    return (int) (busRapidTransitHelper(target) % MOD);
  }

  private long busRapidTransitHelper(long target) {
    if (target == 0) {
      return 0;
    }
    Long result = memo.get(target);
    if (null != result) {
      return result;
    }
    result = target * 1L * inc;
    for (int i = 0; i < jump.length; i++) {
      result = Math.min(result, cost[i] + (target % jump[i]) * 1L * inc + busRapidTransitHelper(target / jump[i]));
      if (target > 1 && (target % jump[i]) != 0) {
        result = Math.min(result, cost[i] + (jump[i] - (target % jump[i])) * 1L * dec + busRapidTransitHelper(target / jump[i] + 1));
      }
    }
    memo.put(target, result);
    return result;
  }

}