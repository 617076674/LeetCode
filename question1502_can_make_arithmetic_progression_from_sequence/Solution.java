package question1502_can_make_arithmetic_progression_from_sequence;

import java.util.Arrays;

/**
 * 时间复杂度是 O(n * logn)，其中 n 为数组 arr 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败99.33%。消耗内存：39.1MB，击败88.36%。
 */
public class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n;
        if (null == arr || (n = arr.length) <= 2) {
            return true;
        }
        Arrays.sort(arr);
        int gap = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            if (gap != arr[i] - arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}