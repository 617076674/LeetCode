package question0446_arithmetic_slices_ii_subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * 状态定义：
 * dp[i][j]：以A[i]结尾的差为j的等差序列的个数（该等差序列的长度最小可以为2）
 *
 * 状态转移：
 * （1）当i == 0时，A[0]这一个元素无法构成一个等差序列，dp[0][j] = 0。
 *
 * （2）当i > 0时，遍历[0, i)中的每一个元素j，记元素A[i]与元素A[j]的差值为gap。
 *
 * 显然A[i]可以跟在A[j]后面，形成差值为gap的dp[j][gap] + 1个等差序列，即dp[i][gap] += dp[j][gap] + 1
 *
 * 为什么此处需要加1呢？因为此时还新增了一个长度为2的等差序列，即A[i], A[j]。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为数组A的长度。
 *
 * 执行用时：174ms，击败65.71%。消耗内存：69.8MB，击败20.83%。
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n, result = 0;
        if (null == A || (n = A.length) < 3) {
            return 0;
        }
        Map<Integer, Integer>[] dp = new Map[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long gap = (long) A[i] - A[j];
                if (gap < Integer.MIN_VALUE || gap > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int) gap, sum = dp[j].getOrDefault(diff, 0);
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + sum + 1);
                result += sum;  //sum统计的是dp[j][gap]的值，如果该值不为0，说明已经存在两个元素，再加上A[i]，就满足了3个元素的要求
            }
        }
        return result;
    }
}