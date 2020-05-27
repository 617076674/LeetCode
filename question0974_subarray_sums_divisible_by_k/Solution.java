package question0974_subarray_sums_divisible_by_k;

/**
 * 哈希表。
 *
 * 时间复杂度是 O(n)，其中 n 为数组 A 的长度。空间复杂度是 O(K)。
 *
 * 执行用时：4ms，击败91.32%。消耗内存：42.6MB，击败100.00%。
 */
public class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int result = 0, sum = 0;
        int[] map = new int[K];
        map[0]++;
        for (int right = 0; right < A.length; right++) {
            sum += A[right];
            int left = (sum % K + K) % K;   // 将负余数转换为正余数
            result += map[left];
            map[left]++;
        }
        return result;
    }
}