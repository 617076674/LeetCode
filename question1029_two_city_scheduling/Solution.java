package question1029_two_city_scheduling;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 公司首先将这2N个人全都安排飞往B市，再选出N个人改变它们的行程，让他们飞往A市。
 * 如果选择改变一个人的行程，那么公司将会额外付出(price_A - price_B)的费用，这个费用可正可负。
 * 因此最优的方案是，选出(price_A - price_B)最小的N个人，让他们飞往A市，其余人飞往B市。
 *
 * 时间复杂度是O(nlogn)，其中n为costs数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：57ms，击败10.28%。消耗内存：37.8MB，击败100.00%。
 */
public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(o -> (o[0] - o[1])));
        int n = costs.length, half = n >> 1, result = 0;
        for (int i = 0; i < half; i++) {
            result += costs[i][0] + costs[i + half][1];
        }
        return result;
    }
}
