package lcci0503_reverse_bits;

/**
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.4MB，击败100.00%。
 */
public class Solution {
    public int reverseBits(int num) {
        int result = 1, preLen = 0, curLen = 0;
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) == 1) {
                curLen++;
            } else {
                result = Math.max(result, curLen + preLen);
                preLen = curLen + 1;
                curLen = 0;
            }
        }
        return Math.max(result, preLen + curLen);
    }
}