package question1137_n_th_tribonacci_number;

/**
 * 和斐波那契数列同样的解法。
 *
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：32.8MB，击败100.00%。
 */
public class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int num0 = 0, num1 = 1, num2 = 1;
        while (n-- >= 3) {
            int tmp = num0 + num1 + num2;
            num0 = num1;
            num1 = num2;
            num2 = tmp;
        }
        return num2;
    }
}
