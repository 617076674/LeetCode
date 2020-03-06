package question0624_maximum_distance_in_arrays;

import java.util.List;

/**
 * 当考虑第i（i > 0）个数组时，可以取第i个数组的最小值和前（i - 1）个数组的最大值，也可以取第i个数组的最大值和前（i - 1）个数组的最小值。
 *
 * 时间复杂度是O(n)，其中n为arrays的长度。空间复杂度是O(1)。
 *
 * 执行用时：8ms，击败55.56%。消耗内存：44.7MB，击败83.33%。
 */
public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE, min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            result = Math.max(result, Math.max(Math.abs(arrays.get(i).get(0) - max),
                    Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min)));
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
        }
        return result;
    }
}