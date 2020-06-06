package question0552_student_attendance_record_ii;

/**
 * 状态压缩。
 *
 * 时间复杂度是 O(n)。空间复杂度是 O(1)。
 *
 * 执行用时：38ms，击败96.24%。消耗内存：36.2MB，击败100.00%
 */
public class Solution3 {
    public int checkRecord(int n) {
        int MOD = 1000000007, num0 = 1, num1 = 1, num2 = 1, num3 = 1, num4 = 1, num5 = 1;
        for (int i = 1; i <= n; i++) {
            int tmp1 = (num0 + num3) % MOD, tmp2 = (num3 + num4) % MOD;
            num0 = (tmp1 + num1) % MOD;
            num1 = (tmp1 + num2) % MOD;
            num4 = (num3 + num5) % MOD;
            num5 = num3;
            num2 = tmp1;
            num3 = tmp2;
        }
        return num0;
    }
}