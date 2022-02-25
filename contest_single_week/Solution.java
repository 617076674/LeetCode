package contest_single_week;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

  private static final int MOD = 1000000007;

  private Set<Integer> valid = new TreeSet<>();

  private int result;

  private List<Integer>[] errorList = new ArrayList[31];

  private static int gcd(int a, int b) {
    if (a == 0) {
      return b;
    }
    return gcd(b % a, a);
  }

  public int numberOfGoodSubsets(int[] nums) {
    int[] map = new int[31];
    for (int num : nums) {
      map[num]++;
    }
    for (int i = 1; i < map.length; i++) {
      if (map[i] > 0 && i != 4 && i != 8 && i != 9 && i != 12 && i != 16 && i != 18 && i != 20 && i != 24 && i != 25 && i != 27 && i != 28) {
        valid.add(i);
      }
    }
    for (int i = 1; i < map.length; i++) {
      for (int j = 1; j < map.length; j++) {
        if (gcd(i, j) != 1) {
          if (errorList[i] == null) {
            errorList[i] = new ArrayList<>();
          }
          errorList[i].add(j);
        }
      }
    }
    dfs(map, 2, quickMul(2, map[1]), true);
    return result;
  }

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

  public static void main(String[] args) {
    System.out.println(new Solution().numberOfGoodSubsets(new int[] {1,2,3,4}));
    System.out.println(new Solution().numberOfGoodSubsets(new int[] {4,2,3,15}));
    System.out.println(new Solution().numberOfGoodSubsets(new int[] {30,28,26,30,19,12,12,25,12}));
    System.out.println(new Solution().numberOfGoodSubsets(new int[] {5,10,1,26,24,21,24,23,11,12,27,4,17,16,2,6,1,1,6,8,13,30,24,20,2,19}));
  }

  private void dfs(int[] map, int index, long temp, boolean empty) {
    if (index == map.length) {
      if (empty) {
        return;
      }
      result += temp;
      result %= MOD;
      return;
    }
    if (valid.contains(index)) {
      Set<Integer> copy = new HashSet<>(valid);
      List<Integer> inValid = errorList[index];
      if (null != inValid) {
        valid.removeAll(inValid);
      }
      dfs(map, index + 1, temp * map[index] % MOD, false);
      valid = copy;
    }
    dfs(map, index + 1, temp % MOD, empty);
  }

}