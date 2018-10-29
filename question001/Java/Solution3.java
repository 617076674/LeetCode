/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81501389
 */
import java.util.HashMap;

public class Solution3 {
	
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int anotherNum = target - nums[i];
			if(hashMap.containsKey(anotherNum)) {
				result[0] = hashMap.get(anotherNum);
				result[1] = i;
				return result;
			}else {
				hashMap.put(nums[i], i);
			}
		}
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		int target = 6;
		int[] result = new Solution3().twoSum(nums, target);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
