package question0256;

/**
 * @author qianyihui
 * @date 2019-08-07
 *
 * 神仙看不懂版本。对Solution1的简化。
 *
 * 时间复杂度是O(n)，其中n为房子的数量。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败90.12%。消耗内存：37.2MB，击败100.00%。
 */
public class Solution2 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) {
            return 0;
        }
        int num1 = costs[0][0], num2 = costs[0][1], num3 = costs[0][2];
        for (int i = 1; i < n; i++) {
            int tmp1 = num1, tmp2 = num2, tmp3 = num3;
            num1 = Math.min(tmp2, tmp3) + costs[i][0];
            num2 = Math.min(tmp1, tmp3) + costs[i][1];
            num3 = Math.min(tmp1, tmp2) + costs[i][2];
        }
        return Math.min(num1, Math.min(num2, num3));
    }
}
