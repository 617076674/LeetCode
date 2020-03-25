package question0523_continuous_subarray_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：23ms，击败42.60%。消耗内存：42.9MB，击败5.71%。
 */
public class Solution2 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return k == 0;
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();    //key是和sum，value是索引
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (0 != k) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}