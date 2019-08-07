package question0042;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82682179
 *
 * 从整个数组的角度看来，如果找到某一索引i左侧的最大值leftMax，以及索引i右侧的最大值rightMax，
 * 就可以知道当前索引i的盛水高度为Math.min(leftMax, rightMax) - height[i]。
 *
 * 时间复杂度是O(n ^ 2)，其中n为height数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：201ms，击败5.03%。消耗内存：48.9MB，击败5.15%。
 */
public class Solution3 {
    public int trap(int[] height) {
        int n = height.length, result = 0;
        if (n == 0 || n == 1) {
            return result;
        }
        for (int i = 1; i < n - 1; i++) {
            int leftMax = 0;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = 0;
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            int min = Math.min(leftMax, rightMax);
            if (min > height[i]) {
                result += min - height[i];
            }
        }
        return result;
    }
}
