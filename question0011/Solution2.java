package question0011;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81407474
 * <p>
 * 首尾双指针遍历。
 * <p>
 * 时间复杂度是O(n)，其中n为height数组的长度。空间复杂度是O(1)。
 * <p>
 * 执行用时：6ms，击败78.08%。消耗内存：44.5MB，击败68.02%。
 */
public class Solution2 {
    public int maxArea(int[] height) {
        int n = height.length, i = 0, j = n - 1;
        int area = (n - 1) * Math.min(height[i], height[j]);
        while (i < j) {
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return area;
    }
}
