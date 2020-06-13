package question0070_climbing_stairs;

/**
 * 状态压缩。
 *
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：89.07%，击败5.66%。
 */
public class Solution2 {
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int num1 = 1, num2 = 2, result = 0;
        for (int i = 3; i <= n; i++) {
            result = num1 + num2;
            num1 = num2;
            num2 = result;
        }
        return result;
    }
}