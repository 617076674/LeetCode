package question1191_k_concatenation_maximum_sum;

/**
 * 当 k == 1 时，参见LeetCode0053。
 *
 * 当 k == 2 时，如果最大和来自两个数组，那么一定是第一个数组的后缀的最大值加上第二个数组的前缀的最大值；如果最大和来自一个数组，同 k == 1。
 *
 * 当 k > 2 时，如果数组 arr 的元素和小于等于 0，同 k == 2；否则，在 k == 2 情况的基础上再加上 k - 2 个数组和。
 *
 * 时间复杂度是 O(n)，其中 n 为 arr 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：8ms，击败35.00%。消耗内存：52.6MB，击败100.00%。
 */
public class Solution {
    private static final int MOD = 1000000007;

    public int kConcatenationMaxSum(int[] arr, int k) {
        int result1 = Math.max(0, singleMaxSum(arr));
        if (k == 1) {
            return result1;
        }
        int result2 = Math.max(result1, doubleMaxSum(arr));
        if (k == 2) {
            return result2;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum <= 0) {
            return result2;
        }
        long mid = (long) sum * (long) (k - 2);
        int result3 = doubleMaxSum(arr) + (int) (mid % MOD);
        return Math.max(result2, result3);
    }

    private int doubleMaxSum(int[] arr) {
        return (maxPreFixSum(arr) + maxSubFixSum(arr)) % MOD;
    }

    private int maxPreFixSum(int[] arr) {
        int result = arr[0], sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            result = Math.max(result, sum);
        }
        return result;
    }

    private int maxSubFixSum(int[] arr) {
        int result = arr[arr.length - 1], sum = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            sum += arr[i];
            result = Math.max(result, sum);
        }
        return result;
    }

    private int singleMaxSum(int[] arr) {
        int sum = 0, result = Integer.MIN_VALUE;
        for (int num : arr) {
            sum += num;
            result = Math.max(sum, result);
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }
}