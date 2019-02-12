package question220;

import java.util.TreeMap;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int left = 0;
        int right = -1;			//[left, right]为我们的滑动窗口
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        while(left < nums.length) {
            if(right + 1 < nums.length && right - left < k) {
                right++;
                Long newNum = (long)nums[right];
                if(treeMap.ceilingKey(- (long)t + newNum) != null) {
                    long ceil = treeMap.ceilingKey(- (long)t + newNum);
                    if(ceil <= (long)t + newNum) {
                        return true;
                    }
                }
                if(treeMap.containsKey(newNum)) {
                    treeMap.put(newNum, treeMap.get(newNum) + 1);
                }else {
                    treeMap.put(newNum, 1);
                }
            }else {
                treeMap.put((long)nums[left], treeMap.get((long)nums[left]) - 1);
                if(treeMap.get((long)nums[left]) == 0) {
                    treeMap.remove((long)nums[left]);
                }
                left++;
            }
        }
        return false;
    }
}
