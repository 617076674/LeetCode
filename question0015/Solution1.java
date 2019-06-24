package question0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三重循环，暴力破解法。
 *
 * 时间复杂度是O(n ^ 3)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution1 {
	public List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		List<List<Integer>> listList = new ArrayList<>();
		Arrays.sort(nums);
		for(int i = 0; i < n; i++) {
			if(nums[i] > 0) {
				break;
			}
			if(i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for(int j = i + 1; j < n; j++) {
				if(nums[i] + nums[j] > 0) {
					break;
				}
				if(j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				for(int k = j + 1; k < n; k++) {
					if(nums[i] + nums[j] + nums[k] > 0) {
						break;
					}
					if(k > j + 1 && nums[k] == nums[k - 1]) {
						continue;
					}
					if(nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						listList.add(list);
					}
				}
			}
		}
		return listList;
	}
}
