package question0552_student_attendance_record_ii;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：1010ms，击败5.01%。消耗内存：83.3MB，击败100.00%
 */
public class Solution1 {
    private int[][] memo;

    private static final int MOD = 1000000007;

    public int checkRecord(int n) {
        memo = new int[n + 1][6];
        return checkRecord(n, 0);
    }

    private int checkRecord(int n, int status) {
        if (n == 0) {
            return 1;
        }
        if (memo[n][status] != 0) {
            return memo[n][status];
        }
        int result = checkRecord(n - 1, status / 3 * 3);   // 填写 P
        result %= MOD;
        if (status <= 2) {
            result += checkRecord(n - 1, 3); // 填写 A
            result %= MOD;
        }
        if (status != 5 && status != 2) {
            result += checkRecord(n - 1, status + 1);  // 填写 L
            result %= MOD;
        }
        memo[n][status] = result;
        return result;
    }
}