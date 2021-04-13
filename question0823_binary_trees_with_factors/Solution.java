package question0823_binary_trees_with_factors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  private static final int MOD = 1000000007;

  private Map<Long, List<int[]>> map = new HashMap<>();

  private Map<Long, Long> memo = new HashMap<>();

  public int numFactoredBinaryTrees(int[] arr) {
    Set<Long> set = new HashSet<>();
    for (int num : arr) {
      set.add((long) num);
    }
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        long multiple = ((long) arr[i]) * arr[j];
        if (set.contains(multiple)) {
          List<int[]> list = map.get(multiple);
          if (null == list) {
            List<int[]> temp = new ArrayList<>();
            temp.add(new int[] {arr[i], arr[j]});
            map.put(multiple, temp);
          } else {
            list.add(new int[] {arr[i], arr[j]});
          }
        }
      }
    }
    long result = 0;
    for (int value : arr) {
      result += numFactoredBinaryTrees(value);
      result %= MOD;
    }
    return (int) result;
  }

  private long numFactoredBinaryTrees(long now) {
    Long temp = memo.get(now);
    if (null != temp) {
      return temp;
    }
    List<int[]> list = map.get(now);
    if (null == list) {
      return 1;
    }
    long result = 1;
    for (int[] pair : list) {
      long left = numFactoredBinaryTrees(pair[0]), right = numFactoredBinaryTrees(pair[1]);
      result += (left * right) % MOD;
      result %= MOD;
      if (pair[0] != pair[1]) {
        result += (left * right) % MOD;
      }
      result %= MOD;
    }
    memo.put(now, result);
    return result;
  }

}