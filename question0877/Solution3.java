package question0877;

/**
 * @author qianyihui
 * @date 2019-08-19
 *
 * 找规律。
 *
 * 当只有2堆石头时，先手必赢。
 *
 * 当有4堆石头时，先手可以拿到第1堆和第3堆或第2堆加第4堆，因此先手只需要拿 第1堆 + 第3堆 或 第2堆 + 第4堆中的较大值即可，必赢。
 *
 * 既然题目假设了两人都足够聪明，而结果又是非数即赢，那么先手必赢。
 *
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：1ms，击败78.50%。消耗内存：34.9MB，击败82.56%。
 */
public class Solution3 {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
