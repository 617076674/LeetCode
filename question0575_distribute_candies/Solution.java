package question0575_distribute_candies;

import java.util.HashSet;
import java.util.Set;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为candies数组的长度。
 *
 * 执行用时：60ms，击败89.46%。消耗内存：45.3MB，击败86.73%
 */
public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(candies.length / 2, set.size());
    }
}
