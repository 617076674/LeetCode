package question1200_minimum_absolute_difference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 先排序。
 *
 * 时间复杂度是O(nlogn)，其中n为arr数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：25ms，击败95.20%。消耗内存：51.4MB，击败100.00%。
 */
public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int gap = arr[i + 1] - arr[i];
            if (gap > min) {
                continue;
            }
            if (gap < min) {
                min = gap;
                result.clear();
            }
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            list.add(arr[i + 1]);
            result.add(list);
        }
        return result;
    }
}
