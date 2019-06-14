package question001.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 用哈希表记录nums[i]元素对应的索引。
 *
 * 注意，nums数组中可能有重复元素，即可能有相同的nums[i]对应不同的索引的情况，因此用哈希表的值对应的是一个List。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度均是O(m)，其中m为nums数组中不同元素的数量。
 *
 * 执行用时：16ms，击败58.84%。消耗内存：40.2MB，击败33.23%。
 */
public class Solution2 {
	
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(nums[i])) {
				hashMap.get(nums[i]).add(i);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				hashMap.put(nums[i], list);
			}
		}
		Arrays.sort(nums);
		int left = 0, right = nums.length - 1;
		while(left < right) {
			if(nums[left] + nums[right] == target) {
				result[0] = hashMap.get(nums[left]).get(0);
				if (nums[left] == nums[right]) {
					result[1] = hashMap.get(nums[right]).get(1);
				} else {
					result[1] = hashMap.get(nums[right]).get(0);
				}
				return result;
			}else if(nums[left] + nums[right] > target) {
				right--;
			}else {
				left++;
			}
		}
        return result;
    }

}
