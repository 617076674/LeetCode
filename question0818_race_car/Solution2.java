package question0818_race_car;

/**
 * https://www.youtube.com/watch?v=HzlEkUt2TYs
 *
 * 记忆化搜索。
 *
 * 时间复杂度是 O(target * log(target))。空间复杂度是 O(target)。
 *
 * 执行用时：2ms，击败91.67%。消耗内存：38.8MB，击败100.00%。
 */
public class Solution2 {
    private int[] memo = new int[10001];    // 走距离 i 所需的最小步数是 memo[i]

    public int racecar(int target) {
        if (memo[target] != 0) {
            return memo[target];
        }
        int n = (int) (Math.log(target + 1) / Math.log(2)), leftBound = (int) Math.pow(2, n) - 1;
        if (leftBound == target) {
            return n;
        }
        int result = Integer.MAX_VALUE;
        // 策略一，走到 rightBound 处，掉头，再往回走
        int rightBound = (int) Math.pow(2, n + 1) - 1;
        result = Math.min(result, n + 2 + racecar(rightBound - target));
        // 策略二，走到 leftBound 处，掉头，往回走 m 步，掉头，接着往前走
        for (int m = 0; m < n; m++) {
            result = Math.min(result, n + m + 2 + racecar((int) (target - leftBound + Math.pow(2, m) - 1)));
        }
        memo[target] = result;
        return result;
    }
}
