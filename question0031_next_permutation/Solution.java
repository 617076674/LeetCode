package question0031_next_permutation;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：37.4MB，击败88.12%。
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 1;
        for (; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {    //如果存在第i个数比第(i - 1)个数更大的情况，说明存在下一个更大的排列
                break;
            }
        }
        if (i >= 1) {   //存在下一个更大的排列
            int j = n - 1;
            for (; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {    //寻找到比第(i - 1)个数更大的数，其索引是j
                    break;
                }
            }
            swap(i - 1, j, nums);   //交换第(i - 1)个数和第j个数
            reverse(nums, i);   //此时[i, n - 1]仍然是一个降序排列，将其反转为一个升序排列
        } else {    //不存在下一个更大的排列
            reverse(nums, 0);
        }
    }

    private void reverse(int[] nums, int index) {
        int i = index, j = nums.length - 1;
        while (i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}