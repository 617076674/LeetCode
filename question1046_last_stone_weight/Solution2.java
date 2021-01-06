package question1046_last_stone_weight;

import java.util.Arrays;

/**
 * 循环排序。
 *
 * 时间复杂度是O(n * nlogn)，其中n为stones数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：1ms，击败99.65%。消耗内存：34.3MB，击败100.00%。
 */
public class Solution2 {

    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        for (int i = n - 1; i > 0; i--) {
            Arrays.sort(stones);
            stones[n - 1] = stones[n - 1] - stones[n - 2];
            stones[n - 2] = 0;
        }
        return stones[n - 1];
    }

}
