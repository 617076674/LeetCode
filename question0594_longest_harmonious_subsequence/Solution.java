package question0594_longest_harmonious_subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为nums数组的长度。
 *
 * 执行用时：74ms，击败64.43%。消耗内存：40.4MB，击败95.42%。
 */
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    private Map<Integer, Integer> numMap = new HashMap<>();

    public int findLHS(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (numMap.containsKey(nums[i])) {
                numMap.put(nums[i], numMap.get(nums[i]) + 1);
            } else {
                numMap.put(nums[i], 1);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                result = Math.max(result, map.get(nums[i]));
            } else {
                int tmpResult = 0, less = 0, greater = 0;
                if (numMap.containsKey(nums[i] - 1)) {
                    less = numMap.get(nums[i] - 1);
                }
                if (numMap.containsKey(nums[i] + 1)) {
                    greater = numMap.get(nums[i] + 1);
                }
                if (less != 0 || greater != 0) {
                    tmpResult += Math.max(less, greater);
                    tmpResult += numMap.get(nums[i]);
                    result = Math.max(result, tmpResult);
                }
            }
        }
        return result;
    }
}
