package question084;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82991438
 */
public class Solution1 {

    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int left = i;
            for (; left >= 0; left--) {
                if(heights[left] < heights[i]){
                    break;
                }
            }
            int right = i;
            for (; right < n; right++) {
                if(heights[right] < heights[i]){
                    break;
                }
            }
            result = Math.max(result, heights[i] * (right - left - 1));
        }
        return result;
    }
}
