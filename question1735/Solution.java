package question1735;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  private static final int MOD = 1000000007;

  private Map<Integer, Map<Integer, Long>> combinationMemo = new HashMap<>();

  private Map<Integer, List<Integer>> factorsMemo = new HashMap<>();

  private List<Integer> primeList = new ArrayList<>();

  private Set<Integer> primeSet = new HashSet<>();

  public int[] waysToFillArray(int[][] queries) {
    for (int i = 2; i <= 10000; i++) {
      if (isPrime(i)) {
        primeList.add(i);
        primeSet.add(i);
      }
    }
    int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      result[i] = waysToFillArrayHelper(queries[i][0], queries[i][1]);
    }
    return result;
  }

  private int waysToFillArrayHelper(int n, int k) {
    Map<Integer, Integer> factor2Count = countFactors(k);
    long result = 1L;
    for (Map.Entry<Integer, Integer> entry : factor2Count.entrySet()) {
      result *= combination(entry.getValue() + n - 1, n - 1);
      result %= MOD;
    }
    return (int) result;
  }

  private long combination(int m, int n) {
    if (m == n || n == 0) {
      return 1L;
    }
    Map<Integer, Long> map = combinationMemo.get(m);
    if (null != map) {
      Long result = map.get(n);
      if (null != result) {
        return result;
      }
    }
    long result = (combination(m - 1, n - 1) + combination(m - 1, n)) % MOD;
    if (null != map) {
      map.put(n, result);
    } else {
      map = new HashMap<>();
      map.put(n, result);
      combinationMemo.put(m, map);
    }
    return result;
  }

  private List<Integer> getFactors(int k) {
    List<Integer> result = factorsMemo.get(k);
    if (null != result) {
      return result;
    }
    result = new ArrayList<>();
    if (primeSet.contains(k)) {
      result.add(k);
      return result;
    }
    for (int prime : primeList) {
      if (prime >= k) {
        break;
      }
      if (k % prime == 0) {
        result.add(prime);
        result.addAll(getFactors(k / prime));
        break;
      }
    }
    factorsMemo.put(k, result);
    return result;
  }

  private Map<Integer, Integer> countFactors(int k) {
    Map<Integer, Integer> result = new HashMap<>();
    List<Integer> factors = getFactors(k);
    for (int factor : factors) {
      result.put(factor, result.getOrDefault(factor, 0) + 1);
    }
    return result;
  }

  private static boolean isPrime(int n) {
    if (n == 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

}