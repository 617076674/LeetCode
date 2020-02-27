package question0436_find_right_interval;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 用哈希表记录左边界对应的索引值，排序后ceil函数二分查找法。
 *
 * 时间复杂度是O(nlogn)，其中n是intervals数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：13ms，击败97.57%。消耗内存：45.3MB，击败90.98%。
 */
public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n;
        if (null == intervals || (n = intervals.length) == 0) {
            return new int[] {};
        }
        Map<Integer, Integer> leftToIndex = new HashMap<>();
        int[] copyOfLeft = new int[n], result = new int[n];
        for (int i = 0; i < n; i++) {
            copyOfLeft[i] = intervals[i][0];
            leftToIndex.put(intervals[i][0], i);
        }
        Arrays.sort(copyOfLeft);
        for (int i = 0; i < n; i++) {
            int ceilIndex = ceil(copyOfLeft, intervals[i][1]);
            if (ceilIndex == -1){
                result[i] = -1;
            } else {
                result[i] = leftToIndex.get(copyOfLeft[ceilIndex]);
            }
        }
        return result;
    }

    private int ceil(int[] nums, int key) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left - 1 >= 0 && nums[left - 1] == key) {
            return left - 1;
        }
        return left == nums.length ? -1 : left;
    }
}