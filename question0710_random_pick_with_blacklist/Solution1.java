package question0710_random_pick_with_blacklist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 白名单中数的个数为 N - len(B)，那么可以直接在 [0, N - len(B)) 中随机生成整数。我们把所有小于 N - len(B) 且
 * 在黑名单中数一一映射到大于等于 N - len(B) 且出现在白名单中的数。这样一来，如果随机生成的整数出现在黑名单中，我们
 * 就返回它唯一对应的那个出现在白名单中的数即可。
 */
public class Solution1 {

  private Map<Integer, Integer> map = new HashMap<>();

  private Random random = new Random();

  private int whiteLen;

  public Solution1(int n, int[] blacklist) {
    whiteLen = n - blacklist.length;
    // 假设 blacklist 中有 m 个数位于区间 [0, whiteLen) 内，
    // 则有 blacklist.size() - m 个数位于区间 [whiteLen, n) 内。
    Set<Integer> set = new HashSet<>();
    for (int i = whiteLen; i < n; i++) {
      set.add(i);
    }
    for (int x : blacklist) {
      set.remove(x);
    }
    // 此时 set 中的元素个数为 n - whiteLen - blacklist.size() + m = m 个。
    // 这里面的元素不在 blacklist 内，且元素范围在 [whiteLen, n) 内。
    Iterator<Integer> iterator = set.iterator();
    for (int i : blacklist) {
      // 在 [0, whiteLen) 中的数不需要进行映射，在 [whiteLen, n) 中的数需要进行映射
      if (i < whiteLen) {
        map.put(i, iterator.next());
      }
    }
  }

  public int pick() {
    int k = random.nextInt(whiteLen);
    return map.getOrDefault(k, k);
  }

}