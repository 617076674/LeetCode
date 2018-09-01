package question018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * ½âÎöÇë¼û£ºhttps://blog.csdn.net/qq_41231926/article/details/82177660
 */
public class Solution3 {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> listList = new ArrayList<>();
		int n = nums.length;
		Arrays.sort(nums);
		for(int i = 0; i < n - 3; i++) {
			if(i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for(int j = i + 1; j < n - 2; j++) {
				if(j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int left = j + 1;
				int right = n - 1;
				while(left < right) {
					if(nums[i] + nums[j] + nums[left] + nums[right] == target) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[left]);
						list.add(nums[right]);
						listList.add(list);
						left++;
						right--;
						while(left < right && nums[left] == nums[left - 1]) {
							left++;
						}
						while(left < right && nums[right] == nums[right + 1]) {
							right--;
						}
					}else if(nums[i] + nums[j] + nums[left] + nums[right] < target) {
						left++;
						while(left < right && nums[left] == nums[left - 1]) {
							left++;
						}
					}else {
						right--;
						while(left < right && nums[right] == nums[right + 1]) {
							right--;
						}
					}
				}
			}
		}
		return listList;
	}
}
