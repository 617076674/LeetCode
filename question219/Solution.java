package question219;

import java.util.HashMap;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        int right = -1;		//[left, right]为我们的滑动窗口
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while(left < nums.length) {
        	if(right + 1 < nums.length && right - left < k) {
        		right++;
        		if(hashMap.containsKey(nums[right])) {
        			return true;
        		}else {
        			hashMap.put(nums[right], 1);
        		}
        	}else {
        		hashMap.put(nums[left], hashMap.get(nums[left]) - 1);
        		if(hashMap.get(nums[left]) == 0) {
        			hashMap.remove(nums[left]);
        		}
        		left++;
        	}
        }
        return false;
    }
}