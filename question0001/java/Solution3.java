package question0001.java;

import java.util.HashMap;

/**
 * 依然用哈希表记录数组中的值对应的索引，但是整个过程只遍历一次nums数组。
 *
 * 边遍历边往哈希表中存键值对。
 *
 * 时间复杂度是O(n)，其中n是nums数组的长度。空间复杂度是O(m)，其中m为nums数组中不同元素的数量。
 *
 * 执行用时：6ms，击败94.35%。消耗内存：39MB，击败48.78%。
 */
public class Solution3 {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int anotherNum = target - nums[i];
			if(hashMap.containsKey(anotherNum)) {
				int[] result = new int[2];
				result[0] = hashMap.get(anotherNum);
				result[1] = i;
				return result;
			}else {
				hashMap.put(nums[i], i);
			}
		}
        return null;
    }
}
