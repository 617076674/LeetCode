package question0228;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败94.55%。消耗内存：34.9MB，击败80.77%。
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return result;
        }
        int left = 0;
        for (int i = 0; i < n - 1; i++) {   //没有考虑最后一个元素
            if (nums[i + 1] - 1 > nums[i]) {
                if (i - left == 0) {    //区间里只有一个数
                    result.add(String.valueOf(nums[i]));
                } else {    //区间里有多个数
                    result.add(nums[left] + "->" + nums[i]);
                }
                left = i + 1;
            }
        }
        //考虑最后一个元素
        if (left == n - 1) {    //如果此时left已经是最后一个数，那么这个最后的区间只有一个数
            result.add(String.valueOf(nums[left]));
        } else {    //如果left不是最后一个数，那么这个最后的区间有多个数
            result.add(nums[left] + "->" + nums[n - 1]);
        }
        return result;
    }
}
