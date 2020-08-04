package question1523_count_odd_numbers_in_an_interval_range;

/**
 * 时间复杂度和空间复杂度均是 O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.1MB，击败94.92%。
 */
public class Solution {
    public int countOdds(int low, int high) {
        boolean lowIsOdd = (low & 1) == 1, highIsOdd = (high & 1) == 1;
        int result = ((high - low + 1) >> 1);
        if (lowIsOdd && highIsOdd) {
            result++;
        }
        return result;
    }
}