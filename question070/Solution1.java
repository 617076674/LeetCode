package question070;

/**
 * @author qianyihui
 * @date 2019-06-14
 *
 * 本题的本质是斐波那契数列的求解：
 *
 * 想爬到第n阶台阶，可以从第n - 1阶台阶一步迈到第n阶台阶，也可以从第n - 2阶台阶一步迈到第n阶台阶。
 *
 * 时间复杂度和空间复杂度均是O(2 ^ n)。
 *
 * 未能通过LeetCode测试，超出时间限制。
 */
public class Solution1 {

    public int climbStairs(int n) {
        if (1 == n) {
            return 1;
        }
        if (2 == n) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

}
