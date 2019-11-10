package question0001_two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * 依然用哈希表记录数组中的值对应的索引，但是整个过程只遍历一次nums数组。
 *
 * 边遍历边往哈希表中存键值对。
 *
 * 时间复杂度是O(n)，其中n是nums数组的长度。空间复杂度是O(m)，其中m为nums数组中不同元素的数量。
 *
 * 执行用时：3ms，击败98.75%。消耗内存：37MB，击败92.85%。
 */
public class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        int n;
        if (null == nums || (n = nums.length) < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int anotherNum = target - nums[i];
            if (map.containsKey(anotherNum)) {
                return new int[] {map.get(anotherNum), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}