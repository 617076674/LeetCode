package question0084_largest_rectangle_in_histogram;

/**
 * 暴力破解法。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为 heights 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1074ms，击败11.15%。消耗内存：41.3MB，击败36.96%。
 */
public class Solution1 {
    public int largestRectangleArea(int[] heights) {
        int n;
        if (null == heights || (n = heights.length) == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int left = i;
            while (left - 1 >= 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            int right = i;
            while (right + 1 < n && heights[right + 1] >= heights[i]) {
                right++;
            }
            result = Math.max(result, (right - left + 1) * heights[i]);
        }
        return result;
    }
}