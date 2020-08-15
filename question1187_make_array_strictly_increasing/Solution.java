package question1187_make_array_strictly_increasing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 状态定义：
 * replace[i][j] 表示用 arr2[j] 替换 arr1[i]，使得 arr1 数组中 [0, i] 范围内的值保持严格递增，所需的最小操作数。
 * keep[i] 表示保持 arr1[i] 不变，使得 arr1 数组中 [0, i] 范围内的值保持严格递增，所需的最小操作数。
 *
 * 初始化条件：
 * replace[0][j] = 1
 * keep[0] = 0
 *
 * 状态转移方程：
 * replace[i][j] = min(replace[i - 1][k], keep[i - 1]) + 1, k ∈ [0, j - 1]
 *
 * if arr1[i] > arr1[i - 1], keep[i] = keep[i - 1]
 * if arr2[j] < arr1[i], keep[i] = min(replace[i - 1][k]), k <= j
 *
 * 时间复杂度和空间复杂度均是 O(n1 * n2)，其中 n1 是数组 arr1 的长度，n2 是数组 arr2 中的非重复数字个数。
 *
 * 执行用时：54ms，击败59.15%。消耗内存：58.3MB，击败21.88%。
 */
public class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr2) {
            set.add(num);
        }
        arr2 = new int[set.size()];
        int index = 0;
        for (int num : set) {
            arr2[index++] = num;
        }
        Arrays.sort(arr2);
        int n1 = arr1.length, n2 = arr2.length;
        int[][] replace = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            Arrays.fill(replace[i], Integer.MAX_VALUE / 2);
        }
        int[] keep = new int[n1];
        Arrays.fill(keep, Integer.MAX_VALUE / 2);
        Arrays.fill(replace[0], 1);
        keep[0] = 0;
        int[] minArray = new int[n2];
        Arrays.fill(minArray, 1);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < n1; i++) {
            if (arr1[i] > arr1[i - 1]) {
                keep[i] = Math.min(keep[i - 1], keep[i]);
            }
            for (int j = 0; j < n2; j++) {
                if (arr2[j] > arr1[i - 1]) {
                    replace[i][j] = Math.min(keep[i - 1] + 1, replace[i][j]);
                }
                if (j > 0) {
                    replace[i][j] = Math.min(replace[i][j], minArray[j - 1] + 1);
                }
                if (arr2[j] < arr1[i]) {
                    keep[i] = Math.min(keep[i], minArray[j]);
                }
                if (i == n1 - 1) {
                    result = Math.min(result, replace[i][j]);
                }
            }
            for (int j = 0; j < n2; j++) {
                minArray[j] = replace[i][j];
                if (j > 0) {
                    minArray[j] = Math.min(minArray[j - 1], replace[i][j]);
                }
            }
            if (i == n1 - 1) {
                result = Math.min(result, keep[i]);
            }
        }
        if (result >= Integer.MAX_VALUE / 2) {
            return -1;
        }
        return result;
    }
}