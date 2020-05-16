package question0560_subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

/**
 * 用哈希表记录前缀和。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 nums 数组的长度。
 *
 * 执行用时：22ms，击败68.49%。消耗内存：40.2MB，击败11.54%。
 */
public class Solution2 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
