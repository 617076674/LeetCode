package question0042_trapping_rain_water;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * 从整个数组的角度看来，如果找到某一索引i左侧的最大值leftMax，以及索引i右侧的最大值rightMax，
 * 就可以知道当前索引i的盛水高度为Math.min(leftMax, rightMax) - height[i]。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为height数组的长度。
 *
 * 执行用时：3ms，击败88.60%。消耗内存：38.1MB，击败78.65%。
 */
public class Solution2 {
    public int trap(int[] height) {
        int n = height.length, result = 0;
        if (n == 0 || n == 1) {
            return 0;
        }
        int[] leftMax = new int[n], rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            rightMax[n - 1 - i] = Math.max(height[n - 1 - i], rightMax[n - i]);
        }
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(leftMax[i - 1], rightMax[i + 1]);
            if (min > height[i]) {
                result += min - height[i];
            }
        }
        return result;
    }
}