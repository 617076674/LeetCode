package question0568_maximum_vacation_days;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O(K * N ^ 2)。空间复杂度是 O(K * N)。
 *
 * 执行用时：84ms，击败31.25%。消耗内存：41.8MB，击败100.00%。
 */
public class Solution1 {
    private int[][] memo;

    public int maxVacationDays(int[][] flights, int[][] days) {
        memo = new int[days.length][days[0].length + 1];
        return maxVacationDays(flights, days, 0, 0);
    }

    /**
     * 现在在编号为城市 city，当前是第 week 个星期的星期一
     */
    private int maxVacationDays(int[][] flights, int[][] days, int city, int week) {
        if (week == days[0].length) {
            return 0;
        }
        if (memo[city][week] != 0) {
            return memo[city][week];
        }
        int result = days[city][week] + maxVacationDays(flights, days, city, week + 1);
        for (int i = 0; i < flights.length; i++) {
            if (flights[city][i] == 1) {
                result = Math.max(result, days[i][week] + maxVacationDays(flights, days, i, week + 1));
            }
        }
        memo[city][week] = result;
        return result;
    }
}