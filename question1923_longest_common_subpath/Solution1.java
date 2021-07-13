package question1923_longest_common_subpath;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1 {

  private static final int MOD1 = 1000000007;

  private static final int MOD2 = 1000000009;

  private static final int BASE1 = 6262441;

  private static final int BASE2 = 9732403;

  public int longestCommonSubpath(int n, int[][] paths) {
    int left = 1, right = Integer.MAX_VALUE;
    for (int i = 0; i < paths.length; i++) {
      right = Math.min(right, paths[i].length);
    }
    while (left < right) {
      if (left + 1 == right) {
        if (check(paths, right)) {
          return right;
        }
        return check(paths, left) ? left : 0;
      }
      int mid = left + ((right - left) >> 1);
      if (check(paths, mid)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return check(paths, left) ? left : 0;
  }

  private static long quickMul(long x, long y, long mod) {
    long result = 1, cur = x;
    while (y > 0) {
      if ((y & 1) == 1) {
        result = result * cur % mod;
      }
      cur = cur * cur % mod;
      y >>= 1;
    }
    return result;
  }

  private static boolean check(int[][] paths, int len) {
    long mult1 = quickMul(BASE1, len, MOD1), mult2 = quickMul(BASE2, len, MOD2);
    Map<Long, Set<Long>> map1 = new HashMap<>();
    for (int i = 0; i < paths.length; ++i) {
      long hash1 = 0, hash2 = 0;
      // 计算首个长度为 len 的子数组的哈希值
      for (int j = 0; j < len; ++j) {
        hash1 = (hash1 * BASE1 + paths[i][j]) % MOD1;
        hash2 = (hash2 * BASE2 + paths[i][j]) % MOD2;
      }
      Map<Long, Set<Long>> map2 = new HashMap<>();
      // 如果我们遍历的是第 0 个数组，或者上一个数组的哈希表中包含该二元组
      // 我们才会将二元组加入当前数组的哈希表中
      if (i == 0 || (map1.containsKey(hash1) && map1.get(hash1).contains(hash2))) {
        Set<Long> set = map2.get(hash1);
        if (null == set) {
          set = new HashSet<>();
          set.add(hash2);
          map2.put(hash1, set);
        } else {
          set.add(hash2);
        }
      }
      // 递推计算后续子数组的哈希值
      for (int j = len; j < paths[i].length; ++j) {
        hash1 =
            ((hash1 * BASE1 % MOD1 - paths[i][j - len] * mult1 % MOD1 + paths[i][j]) % MOD1 + MOD1) % MOD1;
        hash2 =
            ((hash2 * BASE2 % MOD2 - paths[i][j - len] * mult2 % MOD2 + paths[i][j]) % MOD2 + MOD2) % MOD2;
        if (i == 0 || (map1.containsKey(hash1) && map1.get(hash1).contains(hash2))) {
          Set<Long> set = map2.get(hash1);
          if (null == set) {
            set = new HashSet<>();
            set.add(hash2);
            map2.put(hash1, set);
          } else {
            set.add(hash2);
          }
        }
      }
      if (map2.isEmpty()) {
        return false;
      }
      map1 = map2;
    }
    return true;
  }

}