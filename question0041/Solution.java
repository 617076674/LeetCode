package question0041;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82656191
 *
 * 让数组的第i个位置应该存放值i + 1。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败86.07%。消耗内存：34.8MB，击败86.01%。
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 如果是[1, 2, 3]的情况，显然最小没有出现的最小正数是4
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
