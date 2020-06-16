package question1300_sum_of_mutated_array_closest_to_target;

import java.util.Arrays;

/**
 * 时间复杂度是 O(nlogn)，其中 n 为 arr 数组的长度。空间复杂度是 O(n)。
 *
 * 执行用时：7ms，击败16.03%。消耗内存：39.7MB，击败50.00%。
 */
public class Solution {
    public int findBestValue(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int[] sum = new int[n + 1];    // sum[i] = arr[0] + ... + arr[i - 1]
        for (int i = 1; i <= n; i++) {
            sum[i] = arr[i - 1] + sum[i - 1];
        }
        if (sum[n] <= target) {
            return arr[n - 1];
        }
        int i = 0, total = 0;
        for (; i < n; i++) {
            // 将 [i, arr.length - 1] 范围内的值均变为 arr[i]
            total = sum[i] + arr[i] * (n - i);
            if (total == target) {
                return arr[i];
            } else if (total > target) {
                break;
            }
        }
        if (i == 0) {
            int gap = total - target, tmp = gap / n;
            gap -= tmp * n;
            if (gap == 0 || Math.abs(gap - n) >= Math.abs(gap)) {
                return arr[i] - tmp;
            }
            return arr[i] - tmp - 1;
        }
        int value = 0, diff = Integer.MAX_VALUE;
        for (int j = arr[i - 1]; j <= arr[i]; j++) {
            total = sum[i] + j * (n - i);
            if (Math.abs(total - target) < diff) {
                diff = Math.abs(total - target);
                value = j;
                if (diff == 0) {
                    return value;
                }
            }
        }
        return value;
    }
}