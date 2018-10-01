package question046;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82766757
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {

	List<List<Integer>> listList;
	
	public List<List<Integer>> permute(int[] nums) {
		listList = new ArrayList<>();
		permute(nums, new ArrayList<>());
		return listList;
	}
	
	//we put the possible array in list, we are going to find next number
	private void permute(int[] nums, List<Integer> list) {
		int n = nums.length;
		if(list.size() == n) {
			listList.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < n; i++) {
			if(list.contains(nums[i])) {
				continue;
			}
			list.add(nums[i]);
			permute(nums, list);
			list.remove(list.size() - 1);
		}
	}
}
