package question0410_split_array_largest_sum;

public class Solution1 {

    private int[] sums; // sums[i] = nums[0] + ... + nums[i - 1]

    private Integer[][] memo;

    public int splitArray(int[] nums, int m) {
        sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        memo = new Integer[nums.length][nums.length + 1];
        return dfs(nums, 0, m);
    }

    private int dfs(int[] nums, int index, int m) {
        if (m == 1) {
            return sums[nums.length] - sums[index];
        }
        if (memo[index][m] != null) {
            return memo[index][m];
        }
        memo[index][m] = Integer.MAX_VALUE;
        for (int i = index; i <= nums.length - m && sums[i + 1] - sums[index] <= memo[index][m]; i++) {
            memo[index][m] = Math.min(memo[index][m], Math.max(sums[i + 1] - sums[index], dfs(nums, i + 1, m - 1)));
        }
        return memo[index][m];
    }

}