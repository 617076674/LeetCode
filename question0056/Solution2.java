package question0056;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 先根据区间左值对区间进行从小到大排序。
 *
 * 时间复杂度是O(nlogn)，其中n为区间数目。空间复杂度是O(n)。
 *
 * 执行用时：74ms，击败40.53%。消耗内存：45.6MB，击败48.35%。
 */
public class Solution2 {
    public int[][] merge(int[][] intervals) {
        int n;
        if (null == intervals || (n = intervals.length) == 0 || n == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {   //如果后一个区间的左值小于等于本区间的右值，可以将这两个区间合并
                //我们将合并结果存储在后一个区间中，这样我们下一个遍历的区间就是这个合并后的区间
                //因为之前对intervals数组根据区间左值由小到大进行排序，所以合并后新区间的左值是当前区间的左值
                intervals[i + 1][0] = intervals[i][0];
                //但是，合并后新区间的右值需要取当前区间和后一个区间的右值的最大值
                intervals[i + 1][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
            } else {    //如果不能合并，将当前区间的信息存储进list结果集里
                list.add(new Pair<>(intervals[i][0], intervals[i][1]));
            }
            //如果i == n - 2，那么不管第n - 2个区间是否能与第n - 1个区间合并，我们都需要将第n - 1个区间置入结果集中
            if (i == n - 2) {
                list.add(new Pair<>(intervals[n - 1][0], intervals[n - 1][1]));
            }
        }
        //将list转换成数组形式返回
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = list.get(i).getKey();
            result[i][1] = list.get(i).getValue();
        }
        return result;
    }
}
