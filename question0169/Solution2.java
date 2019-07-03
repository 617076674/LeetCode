package question0169;

import java.util.Arrays;

/**
 * 排序后返回中间数。
 *
 * 时间复杂度是O(nlogn)，其中n为nums数组的长度。快排最差的空间复杂度是O(n)，最优的空间复杂度是O(logn)。
 *
 * 执行用时：4ms，击败66.65。消耗内存：51.7MB，击败13.69%。
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
