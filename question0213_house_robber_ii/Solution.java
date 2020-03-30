package question0213;

/**
 * 做两次question0198即可。
 *
 * 因为头尾两房子不可以同时偷取，因此我们将其拆解成两步。
 *
 * 第一次只考虑偷取[0, n - 2]的房子，第二次只考虑偷取[1, n - 1]的房子，其中n为nums数组的长度。
 *
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败97.38%。消耗内存：34.2MB，击败90.00%。
 */
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    public int rob(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return nums[left];
        }
        int num1 = nums[left], num2 = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            int tmp = Math.max(num1 + nums[i], num2);
            num1 = num2;
            num2 = tmp;
        }
        return num2;
    }
}