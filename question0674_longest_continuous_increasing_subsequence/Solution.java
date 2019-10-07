package question0674_longest_continuous_increasing_subsequence;

/**
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败93.06%。消耗内存：37MB，击败96.62%。
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return 0;
        }
        int result = 1;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j + 1 < n && nums[j + 1] > nums[j]) {
                j++;
            }
            result = Math.max(result, j - i + 1);
            i = j;
        }
        return result;
    }
}
