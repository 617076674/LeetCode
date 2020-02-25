package question1051_height_checker;

import java.util.Arrays;

/**
 * 时间复杂度是O(nlogn)，其中n为heights数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：1ms，击败96.98%。消耗内存：37.1MB，击败5.12%。
 */
public class Solution {
    public int heightChecker(int[] heights) {
        int n;
        if (null == heights || (n = heights.length) == 0) {
            return 0;
        }
        int[] copyOfHeights = new int[n];
        for (int i = 0; i < n; i++) {
            copyOfHeights[i] = heights[i];
        }
        Arrays.sort(copyOfHeights);
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] != copyOfHeights[i]) {
                result++;
            }
        }
        return result;
    }
}