package question0403;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 动态规划。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为stones数组的长度。
 *
 * 执行用时：167ms，击败51.47%。消耗内存：54MB，击败39.13%。
 */
public class Solution2 {
    public boolean canCross(int[] stones) {
        if (stones[1] - stones[0] != 1) {
            return false;
        }
        int n = stones.length;
        //map中的key : value，表示当前位置是key，可以通过步长为value的前一步到达当前位置
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);  //当前位置是0，前一步步长也是0
        for (int i = 0; i < n; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[n - 1]).size() > 0;
    }
}
