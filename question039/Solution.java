package question039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82634002
 */
public class Solution {
	
	private List<List<Integer>> listList;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		listList = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum(candidates, target, new ArrayList<>(), 0);
		return listList;
	}
	
	private void combinationSum(int[] candidates, int target, List<Integer> list, int sum) {
		if(sum >= target) {
			if(sum == target) {
				listList.add(new ArrayList<>(list));
			}
			return;
		}
		if(list.size() == 0) {
			for (int i = 0; i < candidates.length; i++) {
				list.add(candidates[i]);
				combinationSum(candidates, target, list, sum + candidates[i]);
				list.remove(list.size() - 1);
			}
		}else {
			for (int i = 0; i < candidates.length; i++) {
				if(candidates[i] >= list.get(list.size() - 1)) {
					list.add(candidates[i]);
					combinationSum(candidates, target, list, sum + candidates[i]);
					list.remove(list.size() - 1);
				}
			}
		}
	}	
}