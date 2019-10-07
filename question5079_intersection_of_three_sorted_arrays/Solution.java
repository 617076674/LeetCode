package question5079_intersection_of_three_sorted_arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间复杂度是O(n1 + n2 + n3)，其中n1为arr1数组的长度，n2为arr2数组的长度，n3为arr3数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败100.00%。消耗内存：39.1MB，击败100.00%。
 */
public class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        findNextNum(arr1, arr2, arr3, 0, 0, 0);
        return result;
    }

    /**
     * 在arr1数组[index1, arr1.length - 1]、arr2数组[index2, arr2.length - 1]和arr3数组[index3, arr3.length - 1]范围内
     * 寻找第一个同时出现的最小正整数。
     */
    private void findNextNum(int[] arr1, int[] arr2, int[] arr3, int index1, int index2, int index3) {
        if (index1 == arr1.length || index2 == arr2.length || index3 == arr3.length) {
            return;
        }
        if (arr1[index1] == arr2[index2] && arr1[index1] == arr3[index3]) {
            result.add(arr1[index1]);
            findNextNum(arr1, arr2, arr3, index1 + 1, index2 + 1, index3 + 1);
            return;
        }
        int min = Math.min(arr1[index1], Math.min(arr2[index2], arr3[index3]));
        if (min == arr1[index1]) {
            index1++;
        }
        if (min == arr2[index2]) {
            index2++;
        }
        if (min == arr3[index3]) {
            index3++;
        }
        findNextNum(arr1, arr2, arr3, index1, index2, index3);
    }
}
