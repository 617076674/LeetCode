package question1217_play_with_chips;

/**
 * 分别统计chips数组中奇数位置的筹码个数和偶数位置的筹码个数。
 *
 * 由于题目规定：不限操作次数，即将位置1处的筹码移动到位置2处的代价是1，将位置1处的筹码移动到位置4的代价也是1。
 *
 * 最终移动到的位置如果是奇数，那么奇数位置的筹码移动的代价为0，而偶数位置的筹码移动的总代价就是偶数位置筹码的个数。
 * 最终移动到的位置如果是偶数，那么偶数位置的筹码移动的代价为0，二奇数位置的筹码移动的总代价就是奇数位置筹码的个数。
 *
 * 时间复杂度是O(n)，其中n为chips数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：34.6MB，击败100.00%。
 */
public class Solution2 {
    public int minCostToMoveChips(int[] chips) {
        int count = 0;
        for (int chip : chips) {
            if ((chip & 1) == 0) {
                count++;
            }
        }
        return Math.min(count, chips.length - count);
    }
}
