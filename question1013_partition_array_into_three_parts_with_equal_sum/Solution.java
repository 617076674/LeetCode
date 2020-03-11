package question1013_partition_array_into_three_parts_with_equal_sum;

/**
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败86.81%。消耗内存44MB，击败100.00%。
 */
public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int n;
        if (null == A || (n = A.length) < 3) {
            return false;
        }
        int[] sum = new int[n]; //sum[i] = A[0] + A[1] + ... + A[i]
        sum[0] = A[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + A[i];
        }
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (!flag && sum[i] * 3 == sum[n - 1]) {
                flag = true;
            } else if (flag && sum[i] * 3 / 2 == sum[n - 1]) {
                return i != n - 1;
            }
        }
        return false;
    }
}