package question0697_degree_of_an_array;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。
 *
 * 一个哈希表map记录nums数组中各元素出现的次数。
 * 一个哈希表leftMap记录nums数组中的元素第一次出现的位置。
 * 一个哈希表rightMap记录nums数组中的元素最后一次出现的位置。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为nums数组的长度。
 *
 * 执行用时：42ms，击败70.99%。消耗内存：40.1MB，击败95.56%。
 */
public class Solution {
    public int findShortestSubArray(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>(), leftMap = new HashMap<>(), rightMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            if (!leftMap.containsKey(nums[i])) {
                leftMap.put(nums[i], i);
            }
            rightMap.put(nums[i], i);
        }
        int maxCount = 0, result = n;
        for (Integer num : map.keySet()) {
            if (map.get(num) > maxCount) {
                maxCount = map.get(num);
                result = rightMap.get(num) - leftMap.get(num) + 1;
            } else if (map.get(num) == maxCount) {
                result = Math.min(rightMap.get(num) - leftMap.get(num) + 1, result);
            }
        }
        return result;
    }
}
