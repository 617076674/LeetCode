package question0026_remove_duplicates_from_sorted_array;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * 双指针遍历原数组。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.99%。消耗内存：44.6MB，击败71.12%。
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return 0;
        }
        int index = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            nums[index] = nums[i];  //由于可能存在重复的元素，所以index指针一定是比i小的
            index++;
        }
        return index;
    }
}