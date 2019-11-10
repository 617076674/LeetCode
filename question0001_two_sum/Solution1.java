package question0001_two_sum;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * 双重循环。
 *
 * 时间复杂度O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：31ms，击败42.91%。消耗内存：37.6MB，击败85.93%。
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int n;
        if (null == nums || (n = nums.length) < 2) {
            return null;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {  //一旦找到了一组符合条件的数据，直接return
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}