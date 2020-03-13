package question0169_majority_element;

/**
 * 摩尔投票法。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败99.76%。消耗内存：41.5MB，击败84.05%。
 */
public class Solution4 {
    public int majorityElement(int[] nums) {
        int result = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (0 == count) {
                count = 1;
                result = nums[i];
            } else if (nums[i] == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
