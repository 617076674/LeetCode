package question1863_sum_of_all_subset_xor_totals;

public class Solution {

    private int result;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return result;
    }

    private void dfs(int[] nums, int index, int xor) {
        if (index == nums.length) {
            result += xor;
            return;
        }
        dfs(nums, index + 1, xor ^ nums[index]);
        dfs(nums, index + 1, xor);
    }

}