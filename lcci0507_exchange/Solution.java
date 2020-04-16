package lcci0507_exchange;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：36.4MB，击败100.00%。
 */
public class Solution {
    public int exchangeBits(int num) {
        int result = 0;
        for (int i = 31; i > 0; i -= 2) {
            int bit1 = ((num >> i) & 1), bit2 = ((num >> (i - 1)) & 1);
            result = result * 2 + bit2;
            result = result * 2 + bit1;
        }
        return result;
    }
}