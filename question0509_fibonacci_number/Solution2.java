package question0509_fibonacci_number;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是O(N)。空间复杂度是O(1)
 *
 * 执行用时：0ms，击败100.00%。消耗内存：33.2MB，击败60.16%。
 */
public class Solution2 {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int num1 = 0, num2 = 1;
        while (N >= 2) {
            N--;
            int tmp = num2;
            num2 = num1 + num2;
            num1 = tmp;
        }
        return num2;
    }
}
