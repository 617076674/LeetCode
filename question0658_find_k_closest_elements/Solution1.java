package question0658_find_k_closest_elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 排序。
 *
 * 时间复杂度是O(nlogn)，其中n为arr数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：27ms，击败17.89%。消耗内存：40.2MB，击败95.74%。
 */
public class Solution1 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Integer[] tmpArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmpArr[i] = arr[i] - x;
        }
        Arrays.sort(tmpArr, (o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        });
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(tmpArr[i] + x);
        }
        Collections.sort(result);
        return result;
    }
}
