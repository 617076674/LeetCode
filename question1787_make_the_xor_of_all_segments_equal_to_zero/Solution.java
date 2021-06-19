package question1787_make_the_xor_of_all_segments_equal_to_zero;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/make-the-xor-of-all-segments-equal-to-zero/solution/shi-suo-you-qu-jian-de-yi-huo-jie-guo-we-uds2/
 *
 * 动态规划。
 */
public class Solution {

  // x 的范围为 [0, 2^10)
  private static final int MAXX = 1 << 10;

  // 极大值，为了防止整数溢出选择 INT_MAX / 2
  private static final int INFTY = Integer.MAX_VALUE / 2;

  public int minChanges(int[] nums, int k) {
    int n = nums.length;
    int[] f = new int[MAXX];
    Arrays.fill(f, INFTY);
    // 边界条件 f(-1,0)=0
    f[0] = 0;
    for (int i = 0; i < k; i++) {
      // 第 i 个组的哈希映射
      Map<Integer, Integer> cnt = new HashMap<>();
      int size = 0;
      for (int j = i; j < n; j += k) {
        cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
        ++size;
      }
      // 求出 t2
      int t2min = Arrays.stream(f).min().getAsInt();
      int[] g = new int[MAXX];
      Arrays.fill(g, t2min);
      for (int mask = 0; mask < MAXX; mask++) {
        // t1 则需要枚举 x 才能求出
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
          int x = entry.getKey(), countx = entry.getValue();
          g[mask] = Math.min(g[mask], f[mask ^ x] - countx);
        }
      }
      // 别忘了加上 size
      for (int j = 0; j < MAXX; ++j) {
        g[j] += size;
      }
      f = g;
    }
    return f[0];
  }

}