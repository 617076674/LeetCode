package question0287_find_the_duplicate_number;

/**
 * 将数字 nums[i] 放在索引 i 处。
 *
 * 时间复杂度是 O(n)，其中 n 为 nums 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败75.46%。消耗内存：39.6MB，击败6.67%。
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                swap(nums, i, nums[i]);
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}