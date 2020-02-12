package question0070_climbing_stairs;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 在Solution1中，我们用一个数组来保存了[1, n]中的所有结果。
 *
 * 实际上，在我们求解第n阶台阶的跳法数量时，只用到了第n - 1阶和第n - 2阶台阶的跳法数量。
 *
 * 因此，我们没有必要全部保存[1, n]的值，只需用两个指针来保存其前一个值和前前一个值即可。
 *
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：89.07%
 */
public class Solution2 {
    public int climbStairs(int n) {
        if (1 == n) {
            return 1;
        }
        if (2 == n) {
            return 2;
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