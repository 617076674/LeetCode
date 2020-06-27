package question0041_first_missing_positive;

/**
 * 让数组的第i个位置应该存放值i + 1。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败86.07%。消耗内存：34.8MB，击败86.01%。
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;   // 如果是[1, 2, 3]的情况，显然最小没有出现的最小正数是4
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}