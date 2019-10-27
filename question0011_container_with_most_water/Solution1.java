package question0011_container_with_most_water;

/**
 * 暴力破解法
 *
 * 时间复杂度是O(n ^ 2)，其中n为height数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：406ms，击败24.18%。消耗内存：45.2MB，击败53.71%。
 */
public class Solution1 {
    public int maxArea(int[] height) {
        int n = height.length, area = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return area;
    }
}