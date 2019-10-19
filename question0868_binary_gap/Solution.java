package question0868_binary_gap;

/**
 * 时间复杂度是O(logN)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：33.3MB，击败70.16%。
 */
public class Solution {
    public int binaryGap(int N) {
        int tmpGap = Integer.MIN_VALUE, gap = 0;
        while (N > 0) {
            if ((N & 1) == 1) {
                gap = Math.max(gap, tmpGap);
                tmpGap = 1;
            } else {
                tmpGap++;
            }
            N >>= 1;
        }
        return gap;
    }
}
