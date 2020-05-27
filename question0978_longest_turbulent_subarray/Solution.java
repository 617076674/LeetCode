package question0978_longest_turbulent_subarray;

/**
 * 用 (A[i] - A[i - 1]) * (A[i - 1] - A[i - 2]) > 0 的判据时可能会产生数据越界而误判。
 *
 * 时间复杂度是 O(n)，其中 n 为数组 A 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：8ms，击败40.82%。消耗内存：42.9MB，击败100.00%。
 */
public class Solution {
    public int maxTurbulenceSize(int[] A) {
        int n;
        if (null == A || (n = A.length) == 0) {
            return 0;
        }
        int result = 0, left = 0;
        for (int right = 1; right < n; right++) {
            if (A[right] == A[right - 1]) {
                result = Math.max(result, right - left);
                left = right;
            } else if (right >= 2 && Integer.compare(A[right], A[right - 1]) * Integer.compare(A[right - 1], A[right - 2]) != -1) {
                result = Math.max(result, right - left);
                left = right - 1;
            }
        }
        return Math.max(result, n - left);
    }
}