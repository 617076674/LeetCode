package question0001_two_sum;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-3chong-jie-fa-by-617076674/
 *
 * 暴力破解法。
 *
 * 时间复杂度O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：54ms，击败33.60%。消耗内存：37.6MB，击败85.83%。
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
}