package question001;

import java.util.HashMap;

/*
 * 解析请见：https://blog.csdn.net/qq_41231926/article/details/81501389
 */
public class Solution2 {
	
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			hashMap.put(i, nums[i]);
		}
		Integer[] numsCopy = new Integer[nums.length];
		for (int i = 0; i < numsCopy.length; i++) {
			numsCopy[i] = i;
		}
		sort(numsCopy, hashMap);
		int left = 0;
		int right = numsCopy.length - 1;
		while(left < right) {
			if(hashMap.get(numsCopy[left]) + hashMap.get(numsCopy[right]) == target) {
				result[0] = numsCopy[left];
				result[1] = numsCopy[right];
				return result;
			}else if(hashMap.get(numsCopy[left]) + hashMap.get(numsCopy[right]) > target) {
				right--;
			}else {
				left++;
			}
		}
        return result;
    }
	
	private void sort(Integer[] arr, HashMap<Integer, Integer> hashMap) {
		sort(arr, 0, arr.length - 1, hashMap);
	}

	private void sort(Integer[] arr, int left, int right, HashMap<Integer, Integer> hashMap) {
		if(left > right) {
			return;
		}
		swap(arr, left, (int)(Math.random() * (right - left + 1)) + left);
		int lessThan = left;			//[left + 1, lessThan]小于left
		int greaterThan = right + 1;	//[greaterThan, right]中的元素大于left
		int i = left + 1;				//[lessThan + 1, i)中的元素等于left
		while(i < greaterThan) {
			if(hashMap.get(arr[i]).compareTo(hashMap.get(arr[left])) == 0 && arr[i] - arr[left] == 0) {
				i++;
			}else if(hashMap.get(arr[i]).compareTo(hashMap.get(arr[left])) > 0) {
				swap(arr, i, greaterThan - 1);
				greaterThan--;
			}else {
				swap(arr, i, lessThan + 1);
				lessThan++;
				i++;
			}
		}
		swap(arr, left, lessThan);
		sort(arr, left, lessThan - 1, hashMap);
		sort(arr, greaterThan, right, hashMap);
	}
	
	private void swap(Integer[] arr, int i, int j) {
		Integer temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		int target = 6;
		int[] result = new Solution2().twoSum(nums, target);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
