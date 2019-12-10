package question0539_minimum_time_difference;

import java.util.Collections;
import java.util.List;

/**
 * 排序后计算。
 *
 * 时间复杂度是O(nlogn)，其中n为timePoints集合的长度。空间复杂度是O(1)。
 *
 * 执行用时：15ms，击败69.70%。消耗内存：38.5MB，击败97.65%。
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int result = calculateGap(timePoints.get(0), timePoints.get(timePoints.size() - 1));
        for (int i = 0; i < timePoints.size() - 1; i++) {
            result = Math.min(result, calculateGap(timePoints.get(i), timePoints.get(i + 1)));
        }
        return result;
    }

    private int calculateGap(String s1, String s2) {
        int h1 = Integer.parseInt(s1.substring(0, 2)), m1 = Integer.parseInt(s1.substring(3, 5)),
                h2 = Integer.parseInt(s2.substring(0, 2)), m2 = Integer.parseInt(s2.substring(3, 5));
        int gap = Math.abs(h1 * 60 + m1 - h2 * 60 - m2);
        return Math.min(gap, 24 * 60 - gap);
    }
}