package question0410;

/**
 * 回溯法。
 *
 * 时间复杂度是O(n!/m!)。空间复杂度是O(m)。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution1 {
    private int result = Integer.MAX_VALUE;

    private int[] sum;  //sum[i]中存储nums数组中[0, i - 1]中的元素和

    public int splitArray(int[] nums, int m) {
        sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        splitArray(nums, 0, m, Integer.MIN_VALUE);
        return result;
    }

    //将nums数组中[0, nums.length - 1]范围内的数字分成m分，返回值是m份数字和的最大值的最小值
    private void splitArray(int[] nums, int start, int m, int max) {
        if (m == 1) {
            result = Math.min(result, Math.max(max, sum[nums.length] - sum[start]));
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            if (start + i <= nums.length - 1 && sum[start + i] - sum[start] <= result) {
                splitArray(nums, start + i, m - 1, Math.max(max, sum[start + i] - sum[start]));
            }
        }
    }
}
