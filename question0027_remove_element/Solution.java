package question0027_remove_element;

/**
 * https://leetcode-cn.com/problems/remove-element/
 *
 * 和question0026同样的思路。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败96.62%。消耗内存：35.5MB，击败84.23%。
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[index++] = nums[i];
        }
        return index;
    }
}