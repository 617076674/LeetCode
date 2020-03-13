package question0169_majority_element;

import java.util.HashMap;
import java.util.Map;

/**
 * 用哈希表记录每个数字出现的次数。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为nums数组的长度。
 *
 * 执行用时：19ms，击败31.78%。消耗内存：39.2MB，击败94.90%。
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) > (nums.length >> 1)) {
                return integer;
            }
        }
        return 0;
    }
}