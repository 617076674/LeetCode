package lcp06_na_ying_bi;

/**
 * 时间复杂度是O(n)，其中n为coins数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.9MB，击败100.00%。
 */
public class Solution {
    public int minCount(int[] coins) {
        int result = 0;
        for (int coin : coins) {
            result += (coin >> 1);
            if ((coin & 1) == 1) {
                result++;
            }
        }
        return result;
    }
}