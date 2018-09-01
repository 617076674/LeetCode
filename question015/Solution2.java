package question015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81449878
 */
public class Solution2 {
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> listList = new ArrayList<>();
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			if(hashMap.containsKey(nums[i])) {
				hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
			}else {
				hashMap.put(nums[i], 1);
			}
		}
		if(hashMap.containsKey(0) && hashMap.get(0) >= 3) {
			addToListList(0, 0, 0, listList);
		}
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (Integer integer : hashMap.keySet()) {
			arrayList.add(integer);
		}
		Collections.sort(arrayList);
		for(int i = 0; i < arrayList.size(); i++) {
			for(int j = i + 1; j < arrayList.size(); j++) {
				if(arrayList.get(i) * 2 + arrayList.get(j) == 0 && hashMap.get(arrayList.get(i)) >= 2) {
					addToListList(arrayList.get(i), arrayList.get(i), arrayList.get(j), listList);
				}
				if(arrayList.get(i) + arrayList.get(j) * 2 == 0 && hashMap.get(arrayList.get(j)) >= 2) {
					addToListList(arrayList.get(i), arrayList.get(j), arrayList.get(j), listList);
				}
				int num = - arrayList.get(i) - arrayList.get(j);
				if(num > arrayList.get(j) && hashMap.containsKey(num)) {
					addToListList(arrayList.get(i), arrayList.get(j), num, listList);
				}
			}
		}
		return listList;
	}
	
	private void addToListList(int num1, int num2, int num3, List<List<Integer>> listList) {
		List<Integer> list = new ArrayList<>();
		list.add(num1);
		list.add(num2);
		list.add(num3);
		listList.add(list);
	}
}
