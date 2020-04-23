package lcci0801_three_steps_problem;

/**
 * 动态规划。
 *
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 *
 * 执行用时：19ms，击败97.88%。消耗内存：36.1MB，击败100.00%。
 */
public class Solution {
    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        int num1 = 1, num2 = 2, num3 = 4, index = 3, mod = 1000000007;
        while (index < n) {
            int tmp = num1;
            num1 = num2;
            num2 = num3;
            num3 = ((tmp + num1) % mod + num2) % mod;
            index++;
        }
        return num3;
    }
}