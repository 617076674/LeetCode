package question1349_maximum_students_taking_exam;

/**
 * 重要性质：第 i 行的学生状态只依赖于第 i - 1 行的学生状态。
 *
 * 状态定义：
 * dp[i][j] 表示第 (i - 1) 行的学生状态是 j 时，前 (i - 1) 行能够容纳的学生数量。
 *
 * 初始化条件：
 * dp[0][j] = 0。
 *
 * 状态转移方程：
 * dp[i][j] = max(dp[i - 1][k] + count(j)), 其中 count(j) 表示 j 的二进制表示中 1 的数量，且 状态 k 和 状态 j 不冲突。
 *
 * 用移位运算来判断两行间的状态是否冲突，以及当前行状态是否合法。
 *
 * 时间复杂度是 O(m * 2 ^ (2 * n))，其中 m 为 seats 的行数，n 为 seats 的列数。空间复杂度是 O(m * 2 ^ n)。
 *
 * 执行用时：74ms，击败7.21%。消耗内存：37.5MB，击败21.74%。
 */
public class Solution {

    public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length, result = Integer.MIN_VALUE;
        int[][] dp = new int[m + 1][1 << n];
        for (int i = 1; i <= m; i++) {   // i = 0，代表的其实是前 0 行
            for (int preStatus = 0; preStatus < (1 << n); preStatus++) {    // 枚举当前行的状态
                for (int curStatus = 0; curStatus < (1 << n); curStatus++) {    // 枚举下一行行的状态
                    boolean flag = true;    // 标志状态 curStatus 是否合法
                    for (int j = 0; j < n; j++) {
                        if ((curStatus & (1 << j)) == 0) {  // 没有坐人，显然合法
                            continue;
                        }
                        if (seats[i - 1][j] == '#' // 当前位置不合法
                            || (j != 0 && (curStatus & (1 << (j - 1))) != 0)    // 左边有人
                            || (j != n - 1 && (curStatus & (1 << (j + 1))) != 0)   // 右边有人
                            || (j != 0 && (preStatus & (1 << (j - 1))) != 0)    // 左上角有人
                            || (j != n - 1 && (preStatus & (1 << (j + 1))) != 0)) { // 右上角有人
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        int count = 0;
                        for (int l = 0; l < 32; l++) {
                            if (((curStatus >> l) & 1) == 1) {
                                count++;
                            }
                        }
                        dp[i][curStatus] = Math.max(dp[i][curStatus], dp[i - 1][preStatus] + count);
                        result = Math.max(result, dp[i][curStatus]);
                    }
                }
            }
        }
        return result;
    }

}