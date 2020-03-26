package question1009_complement_of_base_10_integer;

/**
 * 时间复杂度是O(logN)。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.4MB，击败6.03%。
 */
public class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int result = 0, index = 0;
        while (N > 0) {
            if ((N & 1) == 0) {
                result += (1 << index);
            }
            index++;
            N >>= 1;
        }
        return result;
    }
}