package lcci0501_insert_into_bits;

/**
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.2MB，击败100.00%。
 */
public class Solution {
    public int insertBits(int N, int M, int i, int j) {
        for (int k = i; k <= j; k++) {
            if ((N & (1 << k)) != 0) {
                N -= (1 << k);
            }
        }
        return N + (M << i);
    }
}