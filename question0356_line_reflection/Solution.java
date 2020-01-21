package question0356_line_reflection;

import java.util.Arrays;

/**
 * 先排序，再分段双指针处理。
 *
 * 注意：题目给出的点有可能是重合的点，需要对这些点做一些特殊处理。
 *
 * 时间复杂度是O(nlogn)，其中n是points数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：6ms，击败98.46%。消耗内存40.1MB，击败69.09%。
 */
public class Solution {
    public boolean isReflected(int[][] points) {
        Arrays.sort(points, (point1, point2) -> {
            if (point1[1] == point2[1]) {
                return point1[0] - point2[0];
            }
            return point1[1] - point2[1];
        });
        Integer center = null;
        for (int i = 0; i < points.length; ) {
            int j = i, sum = points[i][0], count = 1;
            while (j + 1 < points.length && points[j + 1][1] == points[i][1]) {
                j++;
                if (points[j - 1][0] != points[j][0]) {
                    sum += points[j][0];
                    count++;
                }
            }
            int left = i, right = j;
            while (left <= right) {
                if (null != center) {
                    if ((points[left][0] + points[right][0]) != center) {
                        return false;
                    }
                } else {
                    center = points[left][0] + points[right][0];
                }
                if (left + 1 < points.length && points[left + 1][0] == points[left][0]) {
                    left++;
                }
                if (right - 1 >= 0 && points[right - 1][0] == points[right][0]) {
                    right--;
                }
                left++;
                right--;
            }
            i = j + 1;
        }
        return true;
    }
}