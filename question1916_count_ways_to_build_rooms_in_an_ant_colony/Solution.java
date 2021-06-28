package question1916_count_ways_to_build_rooms_in_an_ant_colony;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  private static final int MOD = 1000000007;

  private Map<Integer, List<Integer>> childrenMap = new HashMap<>();

  private Map<Integer, long[]> memo = new HashMap<>();

  private long quickMul(long x, long y) {
    long result = 1, cur = x;
    while (y > 0) {
      if ((y & 1) == 1) {
        result = result * cur % MOD;
      }
      cur = cur * cur % MOD;
      y >>= 1;
    }
    return result;
  }

  private long[] fac, inv;

  public int waysToBuildRooms(int[] prevRoom) {
    for (int i = 0; i < prevRoom.length; i++) {
      List<Integer> list = childrenMap.get(prevRoom[i]);
      if (null == list) {
        list = new ArrayList<>();
        list.add(i);
        childrenMap.put(prevRoom[i], list);
      } else {
        list.add(i);
      }
    }
    fac = new long[prevRoom.length];
    inv = new long[prevRoom.length];
    fac[0] = inv[0] = 1;
    for (int i = 1; i < prevRoom.length; i++) {
      fac[i] = fac[i - 1] * i % MOD;
      inv[i] = quickMul(fac[i], MOD - 2);
    }
    long[] result =  postOrderTraversal(0);
    return (int) result[1];
  }

  private long[] postOrderTraversal(int cur) {
    List<Integer> children = childrenMap.get(cur);
    if (null == children) {
      // 1 个 数， 1 种排列
      return new long[] {1, 1};
    }
    long[] result = memo.get(cur);
    if (null != result) {
      return result;
    }
    if (children.size() == 1) {
      long[] temp = postOrderTraversal(children.get(0));
      return new long[] {temp[0] + 1, temp[1]};
    }
    result = new long[2];
    result[1] = 1;
    for (int child : children) {
      long[] temp = postOrderTraversal(child);
      result[1] = result[1] * temp[1] % MOD * inv[(int) temp[0]] % MOD;
      result[0] += temp[0];
    }
    result[1] = result[1] * fac[(int) result[0]] % MOD;
    result[0]++;
    return result;
  }

}