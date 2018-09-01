package question018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * ½âÎöÇë¼û£ºhttps://blog.csdn.net/qq_41231926/article/details/82177660
 */
public class Solution5 {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> listSet = new HashSet<>();
		int n = nums.length;
		Arrays.sort(nums);
		HashMap<Integer, List<Integer[]>> hashMap = new HashMap<>();
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				int num = nums[i] + nums[j];
				Integer[] pair = {i, j};
				if(hashMap.containsKey(num)) {
					hashMap.get(num).add(pair);
				}else {
					List<Integer[]> list = new ArrayList<>();
					list.add(pair);
					hashMap.put(num, list);
				}
			}
		}
		for(int i = 0; i < n - 3; i++) {
			for(int j = i + 1; j < n - 2; j++) {
				int temp = target - nums[i] - nums[j];
				if(!hashMap.containsKey(temp)) {
					continue;
				}
				List<Integer[]> list = hashMap.get(temp);
				for (Integer[] integers : list) {
					if(integers[0] > j) {
						List<Integer> retList = new ArrayList<>();
						retList.add(nums[i]);
						retList.add(nums[j]);
						retList.add(nums[integers[0]]);
						retList.add(nums[integers[1]]);
						listSet.add(retList);
					}
				}

			}
		}
		List<List<Integer>> listList = new ArrayList<>();
		for (List<Integer> list : listSet) {
			listList.add(list);
		}
		return listList;
	}
}
